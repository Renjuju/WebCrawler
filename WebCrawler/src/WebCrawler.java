import java.io.IOException;
import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {
    public static void main(String[] args) {
        Crawler myCrawler = new Crawler();
        Parser  myParser  = new Parser();

        String html = myCrawler.grabHtml("http://www.google.com/imghp?hl=en&tab=wi");
        Vector<String> urls = myParser.getHtmlUrls(html);
        for(int i = 0; i < urls.size(); i++) {
            System.out.println("---------" + i + "----------");
            String crawlerHtml = myCrawler.grabHtml(urls.get(i));
            myParser.getHtmlUrls(crawlerHtml);
        }
    }
}
