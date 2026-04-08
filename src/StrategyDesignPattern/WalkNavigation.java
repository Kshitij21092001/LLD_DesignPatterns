package StrategyDesignPattern;

public class WalkNavigation implements NavigationStrategy{
    @Override
    public void navigate(String source,String destination){
        System.out.println(source+" "+destination+"Walk navigation taken");
    }
}
