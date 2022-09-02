package by.academy.exam.domain;

import java.util.Objects;

public abstract class Plane implements Comparable<Plane>{

    protected String name;
    protected int capacity;
    protected int carryingCapacity;
    protected int petrolBag;
    protected int flightRange;

    public Plane() {
    }

    public Plane(String name, int capacity, int carryingCapacity, int petrolBag, int flightRange) {
        this.name = name;
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.petrolBag = petrolBag;
        this.flightRange = flightRange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public int getPetrolBag() {
        return petrolBag;
    }

    public void setPetrolBag(int petrolBag) {
        this.petrolBag = petrolBag;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return capacity == plane.capacity && carryingCapacity == plane.carryingCapacity && petrolBag == plane.petrolBag && Double.compare(plane.flightRange, flightRange) == 0 && Objects.equals(name, plane.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity, carryingCapacity, petrolBag, flightRange);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", carryingCapacity=" + carryingCapacity +
                ", petrolBag=" + petrolBag +
                ", flightRange=" + flightRange +
                '}';
    }
}
