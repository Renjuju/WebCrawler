import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Parser {

	public static String grabHtml(String url) {
		String html = null;
		try {
			Document doc = Jsoup.connect(url).get();
			html = Jsoup.parseBodyFragment(doc.html()).html();
		} catch (IOException e) {
			System.out.println("Unable to access " + url);
			System.out.println(e.getMessage());
		}
		return html;
	}
	
	public static String getHtmlBody(String html) {
		return Jsoup.parse(html).body().html();
	}
	
	public static Vector<String> getHtmlUrls(String html) {
		Vector<String> urls = new Vector<>();
		Document doc = Jsoup.parse(html);
		Elements links = doc.select("a[href]");
		for(Element link : links) {
			if(link.attr("abs:href").length() > 1) {
				urls.add(link.attr("abs:href"));	
			}
		}
		return urls;
	}
	
    public  synchronized Vector<String> getHtmlUrls(Vector<String> urls, final DataStorage store) {
        Vector<String> urlList = new Vector<>();
        Vector<String> htmlList = new Vector<>();
        List<Future<Vector<String>>> futures = new ArrayList<>();
        for(final String s: urls) {
            ExecutorService es = Executors.newFixedThreadPool(urls.size());
            Future<Vector<String>> threadHtml = es.submit(new Callable<Vector<String>>() {
                @Override
                public Vector<String> call() throws Exception {
                    String html = grabHtml(s);
                    if(html == null) {
                    	return null;
                    }
                    Vector<String> urlVector = getHtmlUrls(html);
                    return urlVector;
                }
            });
            futures.add(threadHtml);
        }

        try {
            for(Future<Vector<String>> f: futures) {
                urlList.addAll(f.get());
            }
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return urlList;
    }
}
