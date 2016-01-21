import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Storage {

    private Vector<String> urlStore = new Vector<>();
    private Vector<Vector<String>> urlStoreWithLevels= new Vector<>();

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

    public void printUrlList(Vector<String> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void addToUrlStoreWithLevels(Vector<String> urlList) {
        urlStoreWithLevels.add(urlList);
    }

    public Vector<Vector<String>> getUrlStoreWithLevels() {
        return urlStoreWithLevels;
    }

    public Vector<String> getUrlStoreWithLevels(int index) throws IndexOutOfBoundsException {
        return urlStoreWithLevels.get(index);
    }

    public void printUrlListWithLevels() {
        System.out.println("Size of store: " + urlStoreWithLevels.size());
        for(int i = 0; i < urlStoreWithLevels.size(); i++) {
            System.out.println("Level " + i);
            for(int x = 0; x < urlStoreWithLevels.get(i).size(); x++) {
                System.out.println(urlStoreWithLevels.get(i).get(x));
            }
            System.out.println("End Level " + i);
        }
    }
}
