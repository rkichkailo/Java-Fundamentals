package by.academy.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

//    Реализуйте метод для выполнения простейшего сжатия строк с использованием счетчика повторяющихся символов.
//Например, строка ааbсссссааа превращается в а2b1с5а3.
//Если сжатая строка не становится короче исходной,
//то метод возвращает исходную строку. Предполагается, что строка состоит
//только из букв верхнего и нижнего регистра (a-z)

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String text;

        while (true){
            System.out.println("Введите стоку состоящую только из латинских букв верхнего и/или нижнего регистра");
            text = scanner.nextLine();
            if (text.matches("[a-zA-Z]+")){
                break;
            } else {
                System.out.println("Вы ввели некоректные символы");
            }
        }
        System.out.println(convert(text.toLowerCase()));
        scanner.close();
    }
    public static String convert(String text){

        StringBuilder str = new StringBuilder(text);
        List <Character> uniqueChars = new ArrayList<>();
        List <Integer> count = new ArrayList<>();
        int number = 1;
        int index = 0;
        StringBuilder result = new StringBuilder();

        if (str.length() == 2){
            return str.toString();
        } else {
            while (index < str.length()){
                uniqueChars.add(str.charAt(index));
                while (index != str.length()-1 && str.charAt(index) == str.charAt(index+1)){
                    number++;
                    index++;
                }
                count.add(number);
                number = 1;
                index++;
            }
            for (int i = 0; i < uniqueChars.size(); i++) {
                result.append(uniqueChars.get(i).toString()).append(count.get(i));
            }
            if (result.length() > text.length()){
                return text;
            }
            return result.toString();
        }
    }
}
