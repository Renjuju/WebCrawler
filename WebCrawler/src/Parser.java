import java.beans.Transient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Parser {


    //    http://stackoverflow.com/questions/8616781/how-to-get-a-web-pages-source-code-from-java
    public static String grabHtml(String url)  {
        StringBuilder html = null;
        try{
            URL urlObj = new URL(url);
            URLConnection urlConnection = urlObj.openConnection();
            BufferedReader input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String line;
            html= new StringBuilder();
            while((line = input.readLine()) != null) {
                html.append(line);
            }
            input.close();
        } catch(Exception e) {
//            e.printStackTrace();
            System.out.println("Website rejected access..");
        } finally {
            if(html == null) {
                return null;
            }
        }

        return html.toString();
    }

    public Vector<String> getHtmlUrls(String html) {
        Vector<String> urls = new Vector<>();

        //Stackoverflow http://stackoverflow.com/questions/8307839/creating-java-regex-to-get-href-link
        Pattern pattern = Pattern.compile("href=\"(.*?)\"");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            if(isCleanUrl(matcher.group(1))) {
                urls.add(matcher.group(1));
            }
        }
//        displayUrls(urls);
        return urls;
    }

//    list of urls
    public  synchronized Vector<String> getHtmlUrls(Vector<String> urls, final DataStorage store) {
        Vector<String> urlList = new Vector<>();
        List<Future<Vector<String>>> futures = new ArrayList<>();
        for(final String s: urls) {
//            WebCrawler grabber = new WebCrawler();

            ExecutorService es = Executors.newFixedThreadPool(urls.size());
            Future<Vector<String>> threadHtml = es.submit(new Callable<Vector<String>>() {
                @Override
                public Vector<String> call() throws Exception {
                    Parser htmlParser = new Parser();
                    String html = grabHtml(s);
                    Vector<String> urlVector = htmlParser.getHtmlUrls(html);
                    return urlVector;
                }
            });
            String html = grabHtml(s);
            if(html == null) {
                continue;
            }
            futures.add(threadHtml);
            urlList.addAll(getHtmlUrls(html));
        }

        try {
            for(Future<Vector<String>> f: futures) {
                urlList.addAll(f.get());
            }
        } catch(Exception e) {

        }
        return urlList;
    }

    private void displayUrls(Vector<String> urls) {
        for(int i = 0; i < urls.size(); i++) {
            System.out.println("#" + i + " " + urls.get(i));
        }
    }

    private boolean isCleanUrl(String url) {
        boolean isClean = true;
        if(url.contains(".js") || !url.contains("http") || url.contains(".css")) {
            isClean = false;
        }
        return isClean;
    }
}
