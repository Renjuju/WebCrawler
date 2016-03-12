import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class WebPage {
	private String url;
	private String html;
	private Double pageRank;

	public WebPage(String url, String html) {
		this.url = url;
		this.html = html;
	}

	public String getUrl() {
		return url;
	}

	public String getHtml() {
		return html;
	}

	public Vector<String> getAllLinks() {
		return Parser.getHtmlUrls(html);
	}

	public Integer getNumberOfOutGoingLinks() {
		return Parser.getHtmlUrls(html).size();
	}

	public void setPageRank(Double pageRank) {
		this.pageRank = pageRank;
	}

	public Double getPageRank() {
		return this.pageRank;
	}

	public String getBaseUrl() {
		URL urlObj;
		try {
			urlObj = new URL(url);
			String baseUrl = "http://" + urlObj.getHost();
			return baseUrl;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
