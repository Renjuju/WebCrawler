import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {
    public static void main(String[] args) {
        Crawler myCrawler = new Crawler();
        Parser  myParser  = new Parser();

        String html = myCrawler.getHtml("http://www.google.com/imghp?hl=en&tab=wi");
        Vector<String> urls = myParser.getHtmlUrls(html);
        for(int i = 0; i < urls.size(); i++) {
            myCrawler.getHtml(urls.get(i));
        }
    }
}
