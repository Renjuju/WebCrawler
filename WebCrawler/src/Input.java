import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Input {
	private String url;
	private int levels;

	private Scanner in = new Scanner(System.in);

	public String getUserUrl() {
		System.out.println("What is the website you would like to start the crawl from?");
		String url = in.nextLine();
		return url;
	}

	public Integer getUserLevelChoices() {
		Integer levels = 0;
		try {
			System.out.println("How many levels deep would you like to go?");
			levels = Integer.parseInt(in.nextLine());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			getUserLevelChoices();
		}

		return levels;
	}

	public Vector<String> getKeyWords() {
		Vector<String> keywords = new Vector<String>();
    	System.out.println("How many keywords would you like to enter?" );
    	Integer numberOfKeywords = 0;
    	try {
    		numberOfKeywords = Integer.parseInt(in.nextLine());
    	} catch(Exception e) {
    		System.out.println("Error: " + e.getMessage());
    		getKeyWords();
    	}
    	
    	for(int i = 0; i < numberOfKeywords; i++) {
    		System.out.println("Enter keyword # " + i);
    		keywords.add(in.nextLine());
    	}
    	return keywords;
    }
}
