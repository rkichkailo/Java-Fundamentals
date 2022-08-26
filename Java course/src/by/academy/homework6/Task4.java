package by.academy.homework6;

import java.io.*;
import java.util.Random;

public class Task4 {
    private static File [] allFiles;
    private static String fullText = "";

    private static final Random random = new Random();

    public Task4() {
    }

    public static void createFile(File dirName, int count) throws IOException {
        File txt;
        int i = 0;
        while (i++ < count) {
            txt = new File(dirName, i + ".txt");
            if (!txt.exists()) {
                txt.createNewFile();
            }
        }
        allFiles = dirName.listFiles();
    }

    public  static void readFile(String sourceFilePath){
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath))) {
            String str;
            while ((str = br.readLine()) != null){
                fullText = fullText.concat(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public  static void writeRandomText(){

        for (File txt: allFiles){
            int randomNum = random.nextInt(fullText.length());

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(txt))) {
                bw.write(fullText.substring(0, randomNum));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void allFilesReport(File report) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(report))) {
            for (File txt: allFiles){
                bw.write(txt.getName() + " - " + txt.length() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
