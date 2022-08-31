package by.academy.homework1;

public class Cat {
    int age;
    String nickName;
    char initials;
    double money;

    boolean isHomeAnimal;

    public Cat(){
    }

    public Cat(String nickName, int age){
        this.nickName = nickName;
        this.age = age;
    }
    public void grow(){
        age++;
    }

    public int getAge() {
        return age;
    }

    public void grow(int addAge){
        System.out.println("Кот растет: " + addAge);
        age = age + addAge;
    }

    public void sleep(){
        System.out.println("Кот спит");
    }

    public void eat(){
        System.out.println("Кот ест");
    }

    public void walk(){
        System.out.println("Кот гуляет");
    }

    public void setInitials(String name){
        this.nickName = name;
        initials = nickName.charAt(0);
    }

    public char getInitials() {
        return initials;
    }

    public void setIsHomeAnimal(boolean homeAnimal) {
        isHomeAnimal = homeAnimal;
    }

    public boolean isHomeAnimal() {
        return isHomeAnimal;
    }

    public void setMoney(double countOfMoney){
        this.money = countOfMoney;
    }
    public double getMoney(){
        return money;
    }
}
