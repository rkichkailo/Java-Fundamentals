package by.academy.homework6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void writeText(File destination, String text, int startIndex){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                (destination))){
            bufferedWriter.write(text.substring(0, startIndex));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            scanner.close();
        }
    }
}
