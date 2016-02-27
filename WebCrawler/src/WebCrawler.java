import java.util.*;

/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {

    private DataStorage store = new DataStorage();
    public String crawl(int levels, String url, Vector<String> keywords) {
    	
    	System.out.println(url);
        String html = Parser.grabHtml(url);
        Parser htmlParser = new Parser();
        
        Vector<String> urlList = new Vector<String>();
    	try {
    		try {
    			urlList= Parser.checkForRobots(url);	
    		} catch(Exception e) { 

    		}
    		
			if(urlList.size() > 0) {
				Vector<String> allUrls = Parser.getHtmlUrls(html);
				allUrls.removeAll(urlList);
				System.out.println("Size of allUrls: " + allUrls.size());
				store.addToUrlStoreWithLevels(allUrls);
			} else {
				urlList = Parser.getHtmlUrls(html);
				store.addToUrlStoreWithLevels(urlList);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
        for(int i = 0; i < levels; i++) {
            htmlParser.getHtmlUrls(urlList, store, i);
            urlList = htmlParser.getUrlList();
            store.addToUrlStoreWithLevels(urlList);
            store.addToHtmlStore(htmlParser.getHtmlList());
        }
//        store.printUrlListWithLevels();
        System.out.println("Total number of sites visited: " + store.size() );
        return "";
    }
}