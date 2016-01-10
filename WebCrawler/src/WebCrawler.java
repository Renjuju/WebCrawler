/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {
    public static void main(String[] args) {
        Crawler myCrawler = new Crawler();
        Parser  myParser  = new Parser();

        System.out.println(myCrawler.getHtml("http://white.net/blog/6-steps-finding-website-urls/"));
        myParser.getHtmlUrls("http://stackoverflow.com/questions/5120171/extract-links-from-a-web-page");
    }
}
