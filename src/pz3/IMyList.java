package pz3;

public interface IMyList<T> extends Iterable{
    void addFirst(T e); // додати елемент у початок контейнеру
    void addLast(T e); // додати елемент у кінець контейнеру
    void add(T e,int index); // додати елемент у контейнер за індексом
    void clear(); // Очистити контейнер
    boolean remove (T o); // видалити елемент із контейнера
    Object[] toArray(); // Повернути масив елементів із контейнера
    int size(); // Повернути кількість елементів у контейнері
    boolean contains(T o); // Перевірити, чи міститься елемент у контейнері (за допомогою методу equals).
}
