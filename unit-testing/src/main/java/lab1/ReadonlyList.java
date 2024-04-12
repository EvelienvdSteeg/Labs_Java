package lab1;


public abstract class ReadonlyList<T> {
    public abstract int length();
    public abstract boolean contains(T item);
    public ReadonlyList<T> add(T item) {
        return new Cons<T>(item, this);
    }
    public static ReadonlyList empty() {
        return Nil.EMPTY;
    } }
class Cons<T> extends ReadonlyList<T> {
    private ReadonlyList<T> tail;
    private T item;
    public Cons(T item, ReadonlyList<T> tail) {
        this.item = item;
        this.tail = tail;
    }
    @Override
    public int length() {
        return 1 + tail.length();
    }
    @Override
    public boolean contains(T item) {
        return this.item == null && item == null
                || (this.item != null && this.item.equals(item))
                || this.tail.contains(item);
    } }
class Nil<T> extends ReadonlyList<T> {
    @Override
    public int length() {
        return 0;
    }
    @Override
    public boolean contains(T item) {
        return false;
    }
    static final ReadonlyList EMPTY = new Nil();
}