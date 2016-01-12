import java.io.IOException;
import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {
    public static void main(String[] args) {

        Crawler webCrawler = new Crawler();
        String html = webCrawler.crawl(1, "http://www.google.com/imghp?hl=en&tab=wi");
    }
}
