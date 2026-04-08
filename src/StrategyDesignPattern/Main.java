package StrategyDesignPattern;

public class Main {
    public static void main(String[] args){
        Navigator nav=new Navigator(new BikeNavigation());

        nav.navigate("Sambhaji Nagar", "Dehradun");

        nav.setStrategy(new CarNavigation());
        nav.navigate("Sambhaji Nagar", "Dehradun");

        nav.setStrategy(new WalkNavigation());
        nav.navigate("Sambhaji Nagar", "Dehradun");
    }
}
