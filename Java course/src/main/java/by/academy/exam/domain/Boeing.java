package by.academy.exam.domain;

import java.util.Objects;

public class Boeing extends Plane {

    private String year;
    private boolean international;

    public Boeing() {
    }

    public Boeing(String name, int capacity, int carryingCapacity, int petrolBag, int flightRange, String year, boolean international) {
        super(name, capacity, carryingCapacity, petrolBag, flightRange);
        this.year = year;
        this.international = international;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Boeing boeing = (Boeing) o;
        return international == boeing.international && Objects.equals(year, boeing.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), year, international);
    }

    @Override
    public String toString() {
        return "Boeing{" +
                "year='" + year + '\'' +
                ", international=" + international +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", carryingCapacity=" + carryingCapacity +
                ", petrolBag=" + petrolBag +
                ", flightRange=" + flightRange +
                '}';
    }

    @Override
    public int compareTo(Plane o) {
        return 0;
    }
}
