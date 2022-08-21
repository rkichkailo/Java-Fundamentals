package by.academy.homework5;

import java.util.Iterator;

public class NewIterator <T> implements Iterator<T> {

    private T[][] items;
    private int i, j;

    public NewIterator() {
        super();
    }

    public NewIterator(T [][] array) {
        this.items = array;
    }

    @Override
    public boolean hasNext() {
        if (items == null || i >= items.length || j >= items[i].length) {
            return false;
        }
        return items[i][j] != null;
    }

    @Override
    public T next() {
        T element = items[i][j++];
        if (j >= items[i].length) {
            i++;
            j = 0;
        }
        return element;
    }
}
