package FactoryDesignPattern;

import FactoryDesignPattern.Cars.Car;
import FactoryDesignPattern.Factory.CarFactory;
import FactoryDesignPattern.Factory.CarFactoryProducer;

public class Main {
    public static void main(String[] args) {

        CarFactoryProducer producer = new CarFactoryProducer();

        CarFactory luxuryFactory = producer.getCarFactory("LuxuryCarFactory");
        Car car1=luxuryFactory.getCar("BMW");
        car1.type();

        Car car2=luxuryFactory.getCar("Mercedes");
        car2.type();

        CarFactory ordinaryFactory=producer.getCarFactory("OrdinaryCarFactory");
        Car car3=ordinaryFactory.getCar("Suzuki");
        car3.type();

        Car car4=ordinaryFactory.getCar("Toyota");
        car4.type();
    }
}
