package by.academy.exam.domain;

import java.util.Objects;

public class Tu extends Plane{
    private String year;
    private boolean international;

    public Tu() {
    }

    public Tu(String name, int capacity, int carryingCapacity, int petrolBag, int flightRange, String year, boolean international) {
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
        Tu tu = (Tu) o;
        return international == tu.international && Objects.equals(year, tu.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), year, international);
    }

    @Override
    public String toString() {
        return "Tu{" +
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
