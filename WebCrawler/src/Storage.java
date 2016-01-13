import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Storage {

    private Vector<String> urlStore = new Vector<>();

    public void addToUrlStore(String url) {
        urlStore.add(url);
    }

    public Vector<String> getUrlList() {
        return urlStore;
    }
}
