package core.stack;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public MateStack() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MateStack(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public void push(T value) {
        if (data.length <= size) {
            resize();
        }
        data[size] = value;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return (T) data[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T value = (T) data[size - 1];
        data[size - 1] = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = (data.length * 3) / 2;
        Object[] biggerArray = new Object[newCapacity];
        System.arraycopy(data, 0, biggerArray, 0, size);
        data = biggerArray;
    }
}
