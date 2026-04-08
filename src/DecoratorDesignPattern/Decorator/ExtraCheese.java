package DecoratorDesignPattern.Decorator;

import DecoratorDesignPattern.Base.BasePizza;

public class ExtraCheese extends Toppings {
    //BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        super(basePizza);
    }

    public int cost(){
        return basePizza.cost()+10;
    }
}
