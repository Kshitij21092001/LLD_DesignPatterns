package FactoryDesignPattern.Factory;

import FactoryDesignPattern.Cars.Car;

public interface CarFactory {
    public Car getCar(String input);
}
