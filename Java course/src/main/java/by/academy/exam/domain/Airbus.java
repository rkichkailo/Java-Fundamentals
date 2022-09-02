package by.academy.exam.domain;

import java.util.Objects;

public class Airbus extends Plane {
    private String year;
    private boolean international;

    public Airbus() {
    }

    public Airbus(String name, int capacity, int carryingCapacity, int petrolBag, int flightRange, String year, boolean international) {
        super(name, capacity, carryingCapacity, petrolBag, flightRange);
        this.year = year;
        this.international = international;
    }

    @Override
    public int compareTo(Plane o) {
        return 0;
    }
}
