import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Parser {

    public Vector<String> getHtmlUrls(String html) {
        Vector<String> urls = new Vector<>();

        //Stackoverflow http://stackoverflow.com/questions/8307839/creating-java-regex-to-get-href-link
        Pattern pattern = Pattern.compile("href=\"(.*?)\"");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            if(isCleanUrl(matcher.group(1))) {
                urls.add(matcher.group(1));
            }
        }
//        displayUrls(urls);
        return urls;
    }

    private void displayUrls(Vector<String> urls) {
        for(int i = 0; i < urls.size(); i++) {
            System.out.println("#" + i + " " + urls.get(i));
        }
    }

    private boolean isCleanUrl(String url) {
        boolean isClean = true;
        if(url.contains(".js") || !url.contains("http") || url.contains(".css")) {
            isClean = false;
        }
        return isClean;
    }
}
