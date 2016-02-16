import java.util.Vector;
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
        Vector<String> keywords = userInput.getKeyWords();
        threadedCrawler.crawlInstance(url, levels, keywords);
        System.exit(-1);
    }
}