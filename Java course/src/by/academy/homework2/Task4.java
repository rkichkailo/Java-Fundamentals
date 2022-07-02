package by.academy.homework2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Количество игроков:");
            int users = scanner.nextInt();

            String[] cards = {"2 бубы", "2 червы", "2 пики", "2 крести",
                    "3 бубы", "3 червы", "3 пики", "3 крести",
                    "4 бубы", "4 червы", "4 пики", "4 крести",
                    "5 бубы", "5 червы", "5 пики", "5 крести",
                    "6 бубы", "6 червы", "6 пики", "6 крести",
                    "7 бубы", "7 червы", "7 пики", "7 крести",
                    "8 бубы", "8 червы", "8 пики", "8 крести",
                    "9 бубы", "9 червы", "9 пики", "9 крести",
                    "10 бубы", "10 червы", "10 пики", "10 крести",
                    "Валет бубы", "Валет червы", "Валет пики", "Валет крести",
                    "Дама бубы", "Дама червы", "Дама пики", "Дама крести",
                    "Король бубы", "Король червы", "Король пики", "Король крести",
                    "Туз бубы", "Туз червы", "Туз пики", "Туз крести"};

            Random random = new Random();

            for(int i = 0; i < cards.length; i++) {
                int index = random.nextInt(i + 1);
                String temp = cards[index];
                cards[index] = cards[i];
                cards[i] = temp;
            }

            int cardAIndex = 0;
            int cardsForUser = 5;

            while (users > 0){
                for (int i = 0; i < cardsForUser; i++) {
                    System.out.print(cards[cardAIndex] + " ");
                    cardAIndex++;
                }
                System.out.println("\n"+ "---------------------------------------");
                users--;
            }
            scanner.close();
        }
    }

