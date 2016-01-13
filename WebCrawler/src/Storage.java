import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Storage {

    private Vector<String> urlStore = new Vector<>();

    public void addToUrlStore(String url) {
        urlStore.add(url);
    }

    public void addToUrlStore(Vector<String> url) {
        for(int i = 0; i < url.size(); i++) {
            urlStore.add(url.get(i));
        }
    }

    public Vector<String> getUrlList() {
        return urlStore;
    }

    public void printUrlList() {
        for(int i = 0; i < urlStore.size(); i++) {
            System.out.println(urlStore.get(i));
        }
    }
}
