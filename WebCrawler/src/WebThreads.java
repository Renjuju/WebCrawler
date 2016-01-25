import java.util.Vector;

/**
 * Created by renju on 1/20/16.
 */
public class WebThreads implements Runnable{
    private Thread t;

    @Override
    public void run() {

    }

    public WebThreads(String url, DataStorage store) {
        Parser htmlParser = new Parser();
//        String html = WebCrawler.grabHtml(url);
//        Vector<String> urlVector = htmlParser.getHtmlUrls(html);
    }
}
