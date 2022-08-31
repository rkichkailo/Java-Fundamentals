package by.academy.homework6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static final String SOURCE_FILE_PATH = "src\\by\\academy\\homework6\\SourceText.txt";
    public static final String MAIN_DIRECTORY = "FilePackage";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        File directory = createDirectory(MAIN_DIRECTORY);

//        Task1

        String text = "";

        while (true){
            System.out.println("Введите текст:" + "\n(введите Stop для завершения записи)");
            text = text.concat(scanner.nextLine()).concat("\n");
            int startIndex = text.toLowerCase().indexOf("stop");

            if(startIndex >= 0) {
                Task1.writeText(createFile(directory, "result_task1.txt"), text, startIndex);
                break;
            }
        }

//        Task2

        File sourceFile = new File(SOURCE_FILE_PATH);
        Task2.copyReplaceText(sourceFile, createFile(directory, "result_task2.txt"));

//        Task 4

        Task4.createFile(createDirectory("All_txt_Files"), 100);
        Task4.readFile(SOURCE_FILE_PATH);
        Task4.writeRandomText();
        Task4.allFilesReport(createFile(directory,"result_task4.txt"));

//        Task 3

        ArrayList<User> allUsers = new ArrayList<>(){{
            add(new User("Danya", "Smirnov", 15));
            add(new User("Irina", "Sidorova", 14));
            add(new User("Lela", "Ivanova", 13));
            add(new User("Dima", "Lepski", 15));
            add(new User("Nick", "Tolstoy", 32));
            add(new User("Katya", "Tolstaya", 33));
            add(new User("David", "Tolstoy", 7));
            add(new User("Emiliya", "Tolstaya", 4));
            add(new User("Aleksei", "Kichkailo", 36));
            add(new User("Nikita", "Kichkailo", 8));
        }
        };
        File users = createDirectory("Users");

        for (User user: allUsers){
            try(BufferedOutputStream write = new BufferedOutputStream(new FileOutputStream(
                    createFile(users, user.getName() + "_" + user.getSurname() + ".txt")));
                ObjectOutputStream oos = new ObjectOutputStream(write)){
                oos.writeObject(user);
            } catch (IOException ex){
                System.err.println(ex.getMessage());
            }
        }

        File [] files = users.listFiles();
        for (File f: files){
            try (BufferedInputStream read = new BufferedInputStream(new FileInputStream(f));
                 ObjectInputStream isu = new ObjectInputStream(read)) {
                System.out.println(isu.readObject());
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static File createDirectory (String dirName){
        File dir = new File(dirName);
        if (!dir.exists()){
            dir.mkdir();
        }
        return dir;
    }
    public static File createFile (File directory, String fileName) throws IOException {
        File file = new File(directory, fileName);
        if (!file.exists()){
            file.createNewFile();
        }
        return file;
    }
}
