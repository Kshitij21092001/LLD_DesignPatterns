package Elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {
    public List<Floor> floors = new ArrayList<>();

    public Building(int totalFloors,ExternalButtonDispatcher dispatcher){
        for(int i=1;i<=totalFloors;i++){
            floors.add(new Floor(i,dispatcher));
        }
    }

    public Floor getFloor(int floorNumber){
        return floors.get(floorNumber-1);
    }
}
