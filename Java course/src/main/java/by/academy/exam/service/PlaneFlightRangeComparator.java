package by.academy.exam.service;

import by.academy.exam.domain.Plane;
import java.util.Comparator;

public class PlaneFlightRangeComparator implements Comparator <Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        return o1.getFlightRange() - o2.getFlightRange();
    }
}
