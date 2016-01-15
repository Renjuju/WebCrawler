import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Crawler {

        private Storage store = new Storage();
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

    public String crawl(int levels, String url) {
        String html = grabHtml(url);
        Parser htmlParser = new Parser();
        Vector<String> urlVector = htmlParser.getHtmlUrls(html);

        store.addToUrlStoreWithLevels(urlVector);
        store.addToUrlStoreWithLevels(htmlParser.getHtmlUrls(urlVector));
        for(int i = 0; i < levels; i++) {
//                what to do

        }

        store.printUrlListWithLevels();

        return "";
    }
}

//        Map.Entry<String,Vector<String>> urlMaps = new AbstractMap.SimpleEntry<>(html, urlVector);
//        Vector<Map.Entry<String, Vector<String>>> vectorMapOfUrls = new Vector<>();
//        vectorMapOfUrls.add(urlMaps);

//        store.getUrlList();
//        Parser parser = new Parser();
//        parser.parseList;
//        returns newList;
//        adds to something