import java.util.Vector;
import java.util.concurrent.ExecutionException;

import sun.font.CreatedFontTracker;

/**
 * Created by Renju R on 1/9/2016.
 */
public class CrawlRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    	CommandCenter cm = new CommandCenter();
    	cm.start();    	
    }
}
