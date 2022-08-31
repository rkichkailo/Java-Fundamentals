package by.academy.homework7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    public static void main(String[] args) {

        Map <Long, String> list = Stream
                .generate(() -> new Random().nextInt(100))
                .limit(100)
                .map(longValue -> (long)( longValue * Math.PI) - 20)
                .filter(longValue -> longValue < 100)
                .sorted()
                .skip(3)
                .peek(s -> System.out.print(s + " "))
                .collect(Collectors.toMap(k -> k, v -> ("Number: " + v), (existing, replacement) -> existing));

        System.out.println();
        System.out.println(list);
    }
}
