import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Output {

	public void printVectorList(Vector<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public void printDualVectorList(Vector<Vector<String>> twoDList) {
		for (int i = 0; i < twoDList.size(); i++) {
			for (int x = 0; x < twoDList.get(i).size(); i++) {
				twoDList.get(i).get(x);
			}
		}
	}

	public static void printWebPages(Vector<WebPage> pages) {
		for (WebPage p : pages) {
			try {
				System.out
						.println(p.getUrl() + "\n" + p.getHtml().substring(0, 5) + "\nrank: " + p.getPageRank() + "\n");
			} catch (Exception e) {

			}
		}
	}

	public static void showOptions() {
		System.out.println("What up player, welcome to the webcrawler, choose an option below");
		System.out.println("1) Start a job");
		System.out.println("2) Pause the jobs");
		System.out.println("3) List & Resume everything");
		System.out.println("4) Quit");
	}
}
