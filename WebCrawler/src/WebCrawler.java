import java.io.IOException;
import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {
    public static void main(String[] args) {

        Crawler webCrawler = new Crawler();
        String html = webCrawler.crawl(2, "http://www.pages.drexel.edu/~rr553/cs164/index.html");
    }
}
