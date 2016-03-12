import java.util.Vector;

public class PageRank {
	private Vector<WebPage> allPages;
	private Vector<WebPage> usuablePages;

	public PageRank(Vector<WebPage> allPages) {
		this.allPages = allPages;
		this.usuablePages = new Vector<WebPage>();
		cleanPages();
	}

	public void calculate() {
		Double dampingFactor = 0.8;
		for (WebPage p : usuablePages) {
			p.setPageRank((1.0 / usuablePages.size()));
		}

		for (int i = 0; i < 3; i++) {
			for (WebPage p : usuablePages) {
				p.setPageRank((1 - dampingFactor) / getNumberOfPages());
				for (WebPage incomingPage : getIncomingPages(p)) {
					p.setPageRank(p.getPageRank()
							+ dampingFactor * incomingPage.getPageRank() / incomingPage.getNumberOfOutGoingLinks());
				}
			}
		}
	}

	private Integer getNumberOfPages() {
		return usuablePages.size();
	}

	private Vector<WebPage> getIncomingPages(WebPage page) {
		Vector<WebPage> incomingPages = new Vector<>();
		for (WebPage p : usuablePages) {
			if (p.getBaseUrl().equals(page.getBaseUrl())) {
				incomingPages.add(p);
			}
		}
		return incomingPages;
	}

	private void cleanPages() {
		for (WebPage p : allPages) {
			if (p.getHtml() != null) {
				usuablePages.add(p);
			}
		}
	}
}
