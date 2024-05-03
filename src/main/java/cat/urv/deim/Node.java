package cat.urv.deim;

public class Node <E extends Comparable<E>> {

    E element;
    Node<E> seguent;
    Node<E> anterior;

    public Node (E elem) {
        element = elem;
        seguent = null;
        anterior = null;
    }

}
