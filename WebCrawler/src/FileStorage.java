import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Renju R on 1/24/2016.
 */
public class FileStorage {

	private String baseFile;

	public FileStorage(String base) {
		baseFile = base;
		createBaseDirectory();
	}

	public void createFile(int level, String html, String fileName) {
		try {
			String x = createDirectory(level);
			x += fileName;
			PrintWriter writer = new PrintWriter(x, "UTF-8");
			writer.println(html);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private void createBaseDirectory() {
		File dir = new File(baseFile);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}

	private String createDirectory(int level) {
		String directoryString = baseFile + "\\";
		for (int i = 0; i <= level; i++) {
			directoryString += String.valueOf(i) + "\\";
			File dir = new File(directoryString);
			if (!dir.exists()) {
				System.out.println("Directory does not exist..creating directory");
				dir.mkdir();
			} else {
				// System.out.println("Directory exists");
			}
		}
		return directoryString;
	}
}
