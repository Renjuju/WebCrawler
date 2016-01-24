import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by renju on 1/20/16.
 */
public class WebThreads implements Runnable{
    private Thread t;

    @Override
    public void run() {
        String html = Crawler.grabHtml("http://google.com");
        Parser htmlParser = new Parser();
        Vector<String> urlVector = htmlParser.getHtmlUrls(html);
        Storage store = new Storage();
        for(int i = 0; i < 2; i++) {
            store.addToUrlStoreWithLevels(urlVector);
            urlVector = htmlParser.getHtmlUrls(urlVector);
            store.printUrlList(urlVector);
        }
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

    private boolean isCleanUrl(String url) {
        boolean isClean = true;
        if(url.contains(".js") || !url.contains("http") || url.contains(".css")) {
            isClean = false;
        }
        return isClean;
    }

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
}
