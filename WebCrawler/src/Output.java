import java.util.Vector;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Output {

    public void printVectorList(Vector<String> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void printDualVectorList(Vector<Vector<String>> twoDList) {
        for(int i = 0; i < twoDList.size(); i++) {
            for(int x = 0; x < twoDList.get(i).size(); i++) {
                twoDList.get(i).get(x);
            }
        }
    }
}
