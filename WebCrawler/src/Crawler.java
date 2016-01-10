import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Crawler {

//    http://stackoverflow.com/questions/8616781/how-to-get-a-web-pages-source-code-from-java
    public String grabHtml(String url)  {
        StringBuilder html = null;
        try{
            URL urlObj = new URL(url);
            URLConnection urlConnection = urlObj.openConnection();
            BufferedReader input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String line;
            html= new StringBuilder();
            while((line = input.readLine()) != null) {
                html.append(line);
            }
            input.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return html.toString();
    }
}
