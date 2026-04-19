package NullObjectPattern;

public class Car implements Vehicle {
    @Override
    public int getFuelCapacity() {
        return 40;
    }

    @Override
    public int getSeatingCapacity() {
        return 5;
    }
}
