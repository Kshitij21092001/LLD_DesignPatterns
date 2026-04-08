package StrategyDesignPattern;

public class CarNavigation implements NavigationStrategy {
    @Override
    public void navigate(String source,String destination){
        System.out.println(source+" "+destination+"Car route taken");
    }
}
