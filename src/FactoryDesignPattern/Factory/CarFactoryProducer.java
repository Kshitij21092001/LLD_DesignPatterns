package FactoryDesignPattern.Factory;

public class CarFactoryProducer {
    public CarFactory getCarFactory(String input){
        switch (input){
            case "LuxuryCarFactory":
                return new LuxuryCarFactory();
            case "OrdinaryCarFactory":
                return new OrdinaryCarFactory();
            default:
                return null;
        }
    }
}
