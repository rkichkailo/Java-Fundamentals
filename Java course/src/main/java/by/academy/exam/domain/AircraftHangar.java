package by.academy.exam.domain;

import java.util.ArrayList;
import java.util.List;

public class AircraftHangar {
    public AircraftHangar() {
    }

    private final List<Plane> allPlanes = new ArrayList<>(){{

        add(new Airbus("Airbus - 104", 100, 200, 500, 5000,  "1990", false));
        add(new Boeing("Boeing - 777", 400, 500, 1000, 10000, "1994", true));
        add(new Tu("Tu - a380", 200, 300, 600, 7000,  "2003", false));
    }
    };

    public String showPlanes(){
        StringBuilder name = new StringBuilder();
        for (Plane p: allPlanes){
            name.append("\n").append(p.toString());
        }
        return name.toString();
    }

    public List<Plane> getAllPlanes() {
        return allPlanes;
    }

}
