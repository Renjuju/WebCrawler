import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CrawlWrapperWithThreads {
	
	Scanner reader = new Scanner(System.in);	
	private String url;
	private int levels;
	private Vector<String> keywords; 
	
	public CrawlWrapperWithThreads(String m_url, int m_levels, Vector<String> m_keywords) {
		this.url = m_url;
		this.levels = m_levels;
		this.keywords = m_keywords;
	}
	
	public void startCrawl() {
		crawlInstance(url, levels, keywords);
	}
	
	public void crawlInstance(final String url, final int levels, final Vector<String> keywords) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Void> x = es.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Crawler(url, levels, keywords);
				return null;
			}
		});
	
		try {
			x.get();
		} catch (InterruptedException e) {
//			e.printStackTrace();
		} catch (ExecutionException e) {
//			e.printStackTrace();
		}
	}
	
	private void Crawler(String url, final int levels, Vector<String> keywords) {
		WebCrawler webCrawler = new WebCrawler();
        long startTime = System.currentTimeMillis();
        String html = webCrawler.crawl(levels, "https://google.com", keywords); 
        long endTime = System.currentTimeMillis() - startTime;
        double totalTime = (double)endTime/1000;
        
        System.out.println("Total time: " + totalTime + " seconds");
        System.out.println("Files saved in root of workspace starting with 0");
	}
}