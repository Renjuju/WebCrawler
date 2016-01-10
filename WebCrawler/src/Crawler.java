import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Crawler {

//    Help from stackoverflow
    public String getHtml(String url) {
        String htmlContent = null;
        URLConnection connection = null;
        try {
            connection = new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            htmlContent = scanner.next();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return htmlContent;
    }
}
