import java.util.Vector;

public class UserData {

	private String url;
	private int levels;
	private Vector<String> keywords;

	public UserData() {

	}

	public void setUserData() {
		Input userInput = new Input();
		url = userInput.getUserUrl();
		levels = userInput.getUserLevelChoices();
		keywords = userInput.getKeyWords();
	}

	public String getUrl() {
		return url;
	}

	public int getLevels() {
		return levels;
	}

	public Vector<String> getKeywords() {
		return keywords;
	}
}