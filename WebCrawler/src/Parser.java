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
    public  synchronized Vector<String> getHtmlUrls(Vector<String> urls, final Storage store) {
        Vector<String> urlList = new Vector<>();
        List<Future<Vector<String>>> futures = new ArrayList<>();
        for(final String s: urls) {
            Crawler grabber = new Crawler();

            ExecutorService es = Executors.newFixedThreadPool(urls.size());
            Future<Vector<String>> threadHtml = es.submit(new Callable<Vector<String>>() {
                @Override
                public Vector<String> call() throws Exception {
                    Parser htmlParser = new Parser();
                    String html = Crawler.grabHtml(s);
                    Vector<String> urlVector = htmlParser.getHtmlUrls(html);
                    return urlVector;
                }
            });
            String html = grabber.grabHtml(s);
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
//        urlList = store.getTempStore();
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
