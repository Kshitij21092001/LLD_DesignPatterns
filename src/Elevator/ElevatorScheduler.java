package Elevator;

import Elevator.Enums.ElevatorDirection;

import java.util.List;

public class ElevatorScheduler {
    public List<ElevatorController> controllers;
    public ElevatorSelectionStrategy strategy;

    public ElevatorScheduler(List<ElevatorController> controllers, ElevatorSelectionStrategy strategy) {
        this.controllers = controllers;
        this.strategy = strategy;
    }

    public void setStrategy(ElevatorSelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public ElevatorController assignElevator(int floor, ElevatorDirection direction) {
        return strategy.selectElevator(controllers, floor, direction);
    }
}
