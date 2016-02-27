import java.util.Vector;
import java.util.concurrent.ExecutionException;

/**
 * Created by Renju R on 1/9/2016.
 */
public class CrawlRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

    	
    	Input userInput = new Input();
    	final String url = "yo";//userInput.getUserUrl();
        final int levels = 2;//userInput.getUserLevelChoices();
        final Vector<String> keywords = null;//userInput.getKeyWords();
//        CrawlWrapperWithThreads threadedCrawler = new CrawlWrapperWithThreads(url, levels, keywords);
//        new Thread(new CrawlWrapperWithThreads(url, levels, keywords)).start();
        Thread myThread = new Thread() {
        	public void run() {
        		WebCrawler crawler = new WebCrawler();
        		crawler.crawl(levels, "https://google.com", keywords);
//        		CrawlWrapperWithThreads threadedCrawler = new CrawlWrapperWithThreads(url, levels, keywords);
//        		threadedCrawler.startCrawl();
//        		threadedCrawler.run();
        	}
        };
        
        Thread anotherThread = new Thread() {
        	public void run() {
        		WebCrawler crawler = new WebCrawler();
        		crawler.crawl(levels, "https://www.drexel.edu", keywords);
//        		CrawlWrapperWithThreads threadedCrawler = new CrawlWrapperWithThreads(url, levels, keywords);
//        		threadedCrawler.startCrawl();
        	}        	
        };
        
        myThread.start();
        anotherThread.start();
        myThread.join();
        anotherThread.join();
        System.exit(-1);
    }
}