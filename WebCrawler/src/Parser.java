import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Parser {
    public Vector<String> getHtmlUrls(String html) {
        Vector<String> urls = new Vector<String>();
        Pattern urlPattern = Pattern.compile("<a[^>]+href=[\"']?([\"'>]+)[\"']?[^>]*>(.+?)<//a>",  Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
        Matcher matcher = urlPattern.matcher(html);
        while(matcher.find()) {
            urls.add(matcher.group());
        }
        displayUrls(urls);
        return urls;
    }

    private void displayUrls(Vector<String> url) {
        System.out.print("Reached");
        for(int i = 0; i < url.size(); i++) {
            System.out.println(url.get(i));
        }
    }
}
