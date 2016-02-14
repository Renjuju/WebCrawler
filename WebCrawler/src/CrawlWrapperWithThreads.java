import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CrawlWrapperWithThreads {
	
	Scanner reader = new Scanner(System.in);	

	public synchronized void crawlInstance(String url, final int levels) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Void> x = es.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				WebCrawler webCrawler = new WebCrawler();
//		        Input userInput = new Input();
//		        String url = userInput.getUserUrl();
		        
//		        int levels = userInput.getUserLevelChoices();
		        long startTime = System.currentTimeMillis();
		        System.out.println("Crawling...spiderman can only shoot so many threads");
		        String html = webCrawler.crawl(levels, "https://google.com"); 
		        long endTime = System.currentTimeMillis() - startTime;
		        double totalTime = (double)endTime/1000;
		        
		        System.out.println("Total time: " + totalTime + " seconds");
		        System.out.println("Files saved in root of workspace starting with 0");
				return null;
			}
		});
	
		try {
			x.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	} 
}