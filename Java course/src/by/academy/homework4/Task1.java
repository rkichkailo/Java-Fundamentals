package by.academy.homework4;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateValidator validator = new DateValidator();
        String date = null;
        String userDate = null;
        boolean creation = true;

        while (creation){
            System.out.println("Введите дату в формате DD-MM-YYYY");
            userDate = scanner.nextLine();
            if(validator.validate(userDate)){
                date = userDate;
                creation = false;
            } else {
                System.out.println("Неправильный формат даты");
            }
        }

        CustomDate customDate = new CustomDate(date);

        System.out.println("День недели: " + customDate.getDayOfWeek());
        System.out.println("Високосный год: " + customDate.isLeapYear());
        System.out.println("Количество дней между текущей датой и " + userDate + ": " + customDate.getDaysBetween());
        scanner.close();
    }
}
