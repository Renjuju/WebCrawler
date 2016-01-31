import java.util.ArrayList;
import java.util.List;

public class WebTree<T> {
	private Node<T> root;

    public WebTree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;
    }	
    
}
