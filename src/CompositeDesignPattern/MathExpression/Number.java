package CompositeDesignPattern.MathExpression;

public class Number implements ArithmeticExpression {
    int number;
    public Number(int number) {
        this.number = number;
    }

    @Override
    public int evaluate() {
        System.out.println("The number is: "+number);
        return number;
    }
}
