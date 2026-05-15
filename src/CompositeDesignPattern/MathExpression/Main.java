package CompositeDesignPattern.MathExpression;

public class Main {
    public static void main(String[] args){
        ArithmeticExpression two = new Number(2);
        ArithmeticExpression seven = new Number(7);
        ArithmeticExpression eight = new Number(8);

        ArithmeticExpression addExpression = new Expression(seven,eight,OperationType.ADD);
        ArithmeticExpression multiplyExpression = new Expression(two,addExpression,OperationType.MULTIPLY);

        System.out.println(multiplyExpression.evaluate());
    }
}
