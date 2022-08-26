package by.academy.homework6;

import java.io.*;

public class Task2 {

    public static void copyReplaceText (File source, File destination){

        try (FileInputStream fileIn = new FileInputStream(source);
             FileOutputStream fileOut = new FileOutputStream(destination)) {
            int a;
            while ((a = fileIn.read()) != -1) {
                if ((char) a == ' ') {
                    continue;
                } else {
                    fileOut.write(a);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
