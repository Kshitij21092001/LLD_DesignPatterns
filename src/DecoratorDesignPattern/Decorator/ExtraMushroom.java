package DecoratorDesignPattern.Decorator;

import DecoratorDesignPattern.Base.BasePizza;

public class ExtraMushroom extends Toppings {
    //BasePizza basePizza;

    public ExtraMushroom(BasePizza basePizza) {
        super(basePizza);
    }

    public int cost(){
        return basePizza.cost()+20;
    }
}
