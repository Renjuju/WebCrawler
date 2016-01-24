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

    }

    public WebThreads(String url, Storage store) {
//        System.out.println("Created a thread");
        Parser htmlParser = new Parser();
        String html = Crawler.grabHtml(url);
        Vector<String> urlVector = htmlParser.getHtmlUrls(html);
        store.tempStore(urlVector);
//        store.printUrlList(urlVector);
    }
}
