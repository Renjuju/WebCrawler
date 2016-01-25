import java.util.concurrent.ExecutionException;

/**
 * Created by Renju R on 1/9/2016.
 */
public class CrawlRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        WebCrawler webCrawler = new WebCrawler();
        Input userInput = new Input();
//        String url = userInput.getUserUrl();
//        int levels = userInput.getUserLevelChoices();
        long startTime = System.currentTimeMillis();
        System.out.println("Crawling...please be patient");
        String html = webCrawler.crawl(2, "https://www.google.com/?gws_rd=ssl");
        long endTime = System.currentTimeMillis() - startTime;
        double totalTime = (double)endTime/1000;
        System.out.println("Total time: " + totalTime + " seconds");
        System.exit(-1);
    }
}