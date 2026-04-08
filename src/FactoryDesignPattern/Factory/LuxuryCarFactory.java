package FactoryDesignPattern.Factory;

import FactoryDesignPattern.Cars.BMW;
import FactoryDesignPattern.Cars.Car;
import FactoryDesignPattern.Cars.Mercedes;

public class LuxuryCarFactory implements CarFactory {
    public Car getCar(String input){
        switch (input){
            case "BMW":
                return new BMW();
            case "Mercedes":
                return new Mercedes();
            default:
                return null;
        }
    }
}
