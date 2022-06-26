package by.academy.homework1;

public class Application {
    public static void main(String[] args) {

        Cat cat1 = new Cat();
        by.academy.homework1.Cat cat2 = new by.academy.homework1.Cat("Grey", 11);

        cat2.eat();
        cat2.sleep();
        cat2.walk();

        int i=0;
        while (i<3){
            cat1.grow();
            i++;
        }
        System.out.println("Возраст котика без имени: " + cat1.getAge());

        cat1.setInitials("Sema");
        System.out.println("Инициалы кототка - " + cat1.getInitials() + ".");

        cat1.setIsHomeAnimal(true);
        System.out.println("Котик домашний? - " + cat1.isHomeAnimal);
    }
}


