package by.academy.homework2;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
//      Условие здачи: ввести 2 слова, состоящие из четного числа букв.
//      Получить слово состоящее из первой половины первого слова и второй половины второго слова

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 слова через пробел, состоящие из четного числа букв");
        String str = scanner.nextLine();

        int i = str.indexOf(" ");

        String firstWord = str.substring(0, i);
        String secondWord = str.substring(i+1, str.length());

        String result1 = firstWord.substring(0, firstWord.length()/2);
        String result2 = secondWord.substring(secondWord.length()/2);


        System.out.println(result1.concat(result2));
        scanner.close();
    }
}
