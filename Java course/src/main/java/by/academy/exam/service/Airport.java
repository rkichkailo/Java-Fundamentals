package by.academy.exam.service;

import by.academy.exam.domain.Plane;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Airport {
    public Airport() {
    }

    public int getAllCapacity(List <Plane> list){
        return list.stream().map(Plane::getCapacity).reduce(Integer::sum).orElse(0);
    }

    public int getAllCarryingCapacity(List <Plane> list){
        return list.stream().map(Plane::getCarryingCapacity).reduce(Integer::sum).orElse(0);
    }
    public List<Plane> sortPlanes(List <Plane> list){
        list.sort(new PlaneFlightRangeComparator());
        return list;
    }
    public List<Plane> filterPetrolBag(List <Plane> list, int min, int max){
        return list.stream().filter(x -> x.getPetrolBag() >= min && x.getPetrolBag() <= max ).collect(Collectors.toList());
    }
}
