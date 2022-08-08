package by.academy.homework4;

import java.util.Iterator;

public class MyIterator <T> implements Iterator <T> {

    private T[] items;
    private int index;

    public MyIterator() {
        super();
    }

    public MyIterator(T [] array) {
        this.items = array;
    }

    @Override
    public boolean hasNext() {
        if (items == null || index >= items.length) {
            return false;
        }
        return items[index] != null;
    }

    @Override
    public T next() {
        return items[index++];
    }
}
