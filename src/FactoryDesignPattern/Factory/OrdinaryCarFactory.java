package FactoryDesignPattern.Factory;

import FactoryDesignPattern.Cars.Car;
import FactoryDesignPattern.Cars.Suzuki;
import FactoryDesignPattern.Cars.Toyota;

public class OrdinaryCarFactory implements CarFactory {
    public Car getCar(String input){
        switch (input){
            case "Suzuki":
                return new Suzuki();
            case "Toyota":
                return new Toyota();
            default:
                return null;
        }
    }
}
