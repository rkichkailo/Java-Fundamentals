package by.academy.homework4;

import java.util.Iterator;

public class Task4 {

    public static void main(String[] args) {

        Integer [] arr = {1,2,3,4,5,6,7,8,9,0};
        MyIterator <Integer> iterator = new MyIterator<>(arr);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
