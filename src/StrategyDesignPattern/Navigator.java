package StrategyDesignPattern;

public class Navigator {
    public NavigationStrategy strategy;

    public Navigator(NavigationStrategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(NavigationStrategy strategy){
        this.strategy = strategy;
    }

    public void navigate(String source,String destination){
        strategy.navigate(source,destination);
    }
}
