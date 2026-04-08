package DecoratorDesignPattern;

import DecoratorDesignPattern.Base.BasePizza;
import DecoratorDesignPattern.Base.VegPizza;
import DecoratorDesignPattern.Decorator.ExtraCheese;
import DecoratorDesignPattern.Decorator.ExtraMushroom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BasePizza pizza1=new VegPizza();
        System.out.println("Veg Pizza" + pizza1.cost());

        BasePizza pizza2=new ExtraCheese(new VegPizza());
        System.out.println("Veg Pizza + Cheese" + pizza2.cost());

        BasePizza pizza3=new ExtraMushroom(new ExtraCheese(new VegPizza()));
        System.out.println("Veg+ExtraCheese+ExtraMushroom" + pizza3.cost());
    }
}