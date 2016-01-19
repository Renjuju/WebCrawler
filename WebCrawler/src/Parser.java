import java.util.Vector;
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
    public Vector<String> getHtmlUrls(Vector<String> urls) {
        Vector<String> urlList = new Vector<>();

        for(String s: urls) {
            Crawler grabber = new Crawler();
            String html = grabber.grabHtml(s);
            if(html == null) {
                continue;
            }
            urlList.addAll(getHtmlUrls(html));
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
