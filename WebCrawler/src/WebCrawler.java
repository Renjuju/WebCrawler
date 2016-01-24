import java.util.concurrent.ExecutionException;

/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Crawler webCrawler = new Crawler();
        Input userInput = new Input();
//        String url = userInput.getUserUrl();
//        int levels = userInput.getUserLevelChoices();
        long startTime = System.currentTimeMillis();
        String html = webCrawler.crawl(1, "https://www.google.com/?gws_rd=ssl");
        long endTime = System.currentTimeMillis() - startTime;
        double totalTime = (double)endTime/1000;
        System.out.println("Total time: " + totalTime + " seconds");
        System.exit(-1);
    }
}












