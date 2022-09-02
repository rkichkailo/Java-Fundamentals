package by.academy.exam.application;

import by.academy.exam.domain.AircraftHangar;
import by.academy.exam.service.Airport;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Airport airport = new Airport();
        AircraftHangar allPlanes = new AircraftHangar();

        System.out.println("Все самолеты: " + allPlanes.showPlanes());
        System.out.println("AllPlanesCapacity = " + airport.getAllCapacity(allPlanes.getAllPlanes()));
        System.out.println("AllPlanesCarryingCapacity = " + airport.getAllCarryingCapacity((allPlanes.getAllPlanes())));
        System.out.println("Sorting all planes by flightRange: " + airport.sortPlanes((allPlanes.getAllPlanes())));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите минимальное значение потребления горючего");
        int min = scanner.nextInt();
        System.out.println("Введите максимальное значение потребления горючего");
        int max = scanner.nextInt();

        System.out.println("Filtering all planes by flightRange: " + airport.filterPetrolBag((allPlanes.getAllPlanes()), min, max));
        scanner.close();
    }
}
