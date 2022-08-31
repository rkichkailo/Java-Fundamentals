package by.academy.homework1;

public class Task4 {
    public static void main(String[] args) {

        int n = 2;
        int i = 0;
        int result = 0;

        while(result < 1_000_000){
            result = (int)Math.pow(n,i);
            System.out.println(result);
            i++;
        }
    }
}
