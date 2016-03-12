import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class WebCrawler {

	private DataStorage store = new DataStorage();
	private Input input = new Input();
	private Vector<WebPage> webPages = new Vector<WebPage>();

	public void crawl(int levels, String url, Vector<String> keywords) {

		System.out.println(url);
		String html = Parser.grabHtml(url);
		webPages.add(new WebPage(url, html));
		Parser htmlParser = new Parser(keywords);
		store.setBaseUrl(url);
		Vector<String> urlList = new Vector<String>();
		try {
			try {
				urlList = Parser.checkForRobots(url);
			} catch (Exception e) {

			}

			if (urlList.size() > 0) {
				Vector<String> allUrls = Parser.getHtmlUrls(html);
				allUrls.removeAll(urlList);
				store.addToUrlStoreWithLevels(allUrls);
			} else {
				urlList = Parser.getHtmlUrls(html);
				store.addToUrlStoreWithLevels(urlList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < levels; i++) {
			htmlParser.getHtmlUrls(urlList, store, i, webPages);
			urlList = htmlParser.getUrlList();
			store.addToUrlStoreWithLevels(urlList);
			store.addToHtmlStore(htmlParser.getHtmlList());
		}
		PageRank pageRank = new PageRank(webPages);
		pageRank.calculate();
		Output.printWebPages(webPages);
		Output.showOptions();
	}
}