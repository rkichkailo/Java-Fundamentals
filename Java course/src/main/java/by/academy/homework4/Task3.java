package by.academy.homework4;

import java.util.Arrays;

public class Task3 <T> {
    private T[] items;
    private int index;

    public Task3(){
        super();
        this.items = (T[]) new Object[16];
    }
    public Task3(int i){
        this.items = (T[]) new Object[i];
    }

    public void add(T item){
        if (items.length == index)
            grow();
        items[index] = item;
        index++;
    }

    private void grow(){
        int newLength = (int) (items.length == 0 ? 1 : items.length * 1.5);
        T[] tempItems = (T[]) new Object[newLength];
        System.arraycopy(items, 0, tempItems, 0, items.length);
        items = tempItems;
    }

    public T getItem(int i){
        return items[i];
    }

    public T getFirst(){
        return items[0];
    }

    public T getLast(){
        return items[items.length-1];
    }

    public int getSize(){
        return items.length;
    }

    public T getLastAdded(){
        return items[index-1];
    }

    public void remove(int i){
        System.arraycopy(items, i + 1, items, i, (items.length - i) - 1);
        index--;
    }

    public void remove(T item){
        int itemIndex = 0;
        boolean findItem = false;
        while (itemIndex < index){
            if(items[itemIndex].equals(item)){
                findItem = true;
                break;
            }
            itemIndex++;
        }
        if (findItem){
            remove(itemIndex);
        } else {
            System.out.println("Элемент не найден");
        }
    }

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public static void main(String[] args) {
        Task3 <String> app = new Task3<>();

        app.add("10");
        app.add("20");
        app.add("30");
        app.add("40");
        app.add("50");
        app.add("60");
        app.add("70");
        System.out.println(app.getSize());
        System.out.println(Arrays.toString(app.getItems()));
        System.out.println(app.getItem(3));
        System.out.println(app.getFirst());
        System.out.println(app.getLast());
        System.out.println(app.getSize());
        System.out.println(app.getLastAdded());
        app.remove(2);
        System.out.println(Arrays.toString(app.getItems()));
        System.out.println(app.getItem(4));
        System.out.println(app.getFirst());
        System.out.println(app.getLast());
        System.out.println(app.getSize());
        System.out.println(app.getLastAdded());
        app.remove("55");
        System.out.println(Arrays.toString(app.getItems()));
        app.add("80");
        System.out.println(app.getSize());
        System.out.println(Arrays.toString(app.getItems()));
        System.out.println(app.getItem(4));
        System.out.println(app.getFirst());
        System.out.println(app.getLast());
        System.out.println(app.getSize());
        System.out.println(app.getLastAdded());
    }
}
