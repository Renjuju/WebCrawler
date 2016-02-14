import java.util.concurrent.ExecutionException;

/**
 * Created by Renju R on 1/9/2016.
 */
public class CrawlRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

    	CrawlWrapperWithThreads threadedCrawler = new CrawlWrapperWithThreads();
    	Input userInput = new Input();
    	String url = userInput.getUserUrl();
        int levels = userInput.getUserLevelChoices();
        threadedCrawler.crawlInstance(url, levels);

//        WebCrawler webCrawler = new WebCrawler();
//        long startTime = System.currentTimeMillis();
//        
//        System.out.println("Crawling...spiderman can only shoot so many threads");
//        String html = webCrawler.crawl(levels, "https://google.com"); 
//        long endTime = System.currentTimeMillis() - startTime;
//        double totalTime = (double)endTime/1000;
//        
//        System.out.println("Total time: " + totalTime + " seconds");
//        System.out.println("Files saved in root of workspace starting with 0");
        System.exit(-1);
    }
}