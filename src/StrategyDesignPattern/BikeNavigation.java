package StrategyDesignPattern;

public class BikeNavigation implements NavigationStrategy {
    @Override
    public void navigate(String source,String destination){
        System.out.println(source+" "+destination+"Bike navigation taken");
    }
}
