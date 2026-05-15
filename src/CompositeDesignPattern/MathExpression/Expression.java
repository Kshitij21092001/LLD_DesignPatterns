package CompositeDesignPattern.MathExpression;

public class Expression implements ArithmeticExpression {
    private ArithmeticExpression left;
    private ArithmeticExpression right;
    private OperationType operation;

    public Expression(ArithmeticExpression left, ArithmeticExpression right, OperationType operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public int evaluate() {
        int value = 0;
        switch (operation) {
            case ADD:
                value = left.evaluate()+right.evaluate();
                break;
            case SUBTRACT:
                value = left.evaluate()-right.evaluate();
                break;
            case MULTIPLY:
                value = left.evaluate()*right.evaluate();
                break;
            case DIVIDE:
                value = left.evaluate()/right.evaluate();
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        System.out.println("The expression value is: "+value);
        return value;
    }
}
