package DecoratorDesignPattern.Decorator;

import DecoratorDesignPattern.Base.BasePizza;

public abstract class Toppings implements BasePizza {
    BasePizza basePizza;
    public Toppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
}
