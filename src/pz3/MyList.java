package pz3;

import java.util.*;

public class MyList<T> implements IMyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T e) {
        Node<T> newNode = new Node(null, e, head);
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(T e) {
        Node<T> newNode = new Node(tail, e, null);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public void add(T e, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index = " + index);
        } else if (size == 0 || index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<T> temp = head;
            int i = -1;
            while (temp != null)
                if (index - 1 == i) {
                    Node<T> newNode = new Node(temp.prev, e, temp);
                    temp.prev = newNode;
                    size++;
                    return;
                } else {
                    temp = temp.next;
                    i++;
                }
        }
    }

    public void clear() { // Очистити контейнер
        Node<T> temp = head;
        while (temp != null) {
            temp.prev = null;
            temp = temp.next;
            size--;
        }
        head = null;
        tail = null;
    }

    public boolean remove(T o) { // видалити елемент із контейнера
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                if (temp.prev == null) { //якщо перший елемент
                    head = temp.next;
                    head.prev = null;
                } else if (temp.next == null) { //якщо останній
                    tail = temp.prev;
                    tail.next = null;
                } else {                        //якщо всередині
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                size--;
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    public Object[] toArray() { // Повернути масив елементів із контейнера
        Object[] arr = new Object[size];
        int i = -1;
        Node<T> temp = head;
        while (temp != null) {
            arr[++i] = temp.data;
            temp = temp.next;
        }
        return arr;
    }

    public int size() { // Повернути кількість елементів у контейнері
        return size;
    }

    public boolean contains(T o) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "";
        }
        System.out.print("{");
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp);
            temp = temp.next;
            if (temp == null) {
                System.out.print("}");
            } else {
                System.out.println(",");
            }
        }
        return "";
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public Iterator<T> iterator() {
        return new IteratorImpl(head);
    }

    private class IteratorImpl implements Iterator<T> {
        private Node<T> currentNode;
        private boolean flagToRemove = false;
        public IteratorImpl(Node<T> head) {
            currentNode = head;
        }
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = currentNode.data;
            currentNode = currentNode.next;
            return value;
        }
        @Override
        public void remove() {
            if (!flagToRemove) {
                throw new IllegalStateException();
            }
            MyList.this.remove(currentNode.prev.data);
            flagToRemove = false;
        }
    }
}

