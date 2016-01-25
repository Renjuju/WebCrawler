import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {

    private DataStorage store = new DataStorage();
    private Parser parser = new Parser();

    public synchronized String crawl(int levels, String url) {
        String html = parser.grabHtml(url);
        Parser htmlParser = new Parser();
        Vector<String> urlVector = htmlParser.getHtmlUrls(html);
        store.addToUrlStoreWithLevels(urlVector);
        for(int i = 1; i < levels; i++) {
            urlVector = htmlParser.getHtmlUrls(urlVector, store);
            store.addToUrlStoreWithLevels(urlVector);
//            store.printUrlList(store.getUrlStoreWithLevels(i));
        }
        store.printUrlListWithLevels();
//          store.printUrlList(store.getTempStore());
        System.out.println("Total number of sites visited: " + store.size() );

        return "";
    }
}