package pz3;

public class Node<T>{
   public Node<T> prev;
   public T data;
   public Node<T> next;
    public Node( Node<T> prev,T data, Node<T> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
    public String toString(){
        return "[" + data.toString() + "]";
    }
}
