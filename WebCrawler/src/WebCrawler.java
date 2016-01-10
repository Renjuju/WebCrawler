/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {
    public static void main(String[] args) {
        Crawler myCrawler = new Crawler();
        System.out.println(myCrawler.getHtml("http://google.com"));
    }
}
