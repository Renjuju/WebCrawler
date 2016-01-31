import java.util.*;

/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {

    private DataStorage store = new DataStorage();
    public synchronized String crawl(int levels, String url) {
    	
    	System.out.println(url);
        String html = Parser.grabHtml(url);
        Parser htmlParser = new Parser();
        Vector<String> urlVector = Parser.getHtmlUrls(html);
        store.addToUrlStoreWithLevels(urlVector);
        
        for(int i = 0; i < levels; i++) {
            htmlParser.getHtmlUrls(urlVector, store, i);
            urlVector = htmlParser.getUrlList();
            store.addToUrlStoreWithLevels(urlVector);
            store.addToHtmlStore(htmlParser.getHtmlList());
        }
        store.printUrlListWithLevels();
        System.out.println("Total number of sites visited: " + store.size() );
        return "";
    }
}