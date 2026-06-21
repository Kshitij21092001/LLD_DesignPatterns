package AdapterDesignPattern.Adaptee;

public class ImperialWeightMachine implements WeightMachine{
    private double measuredWeightInPounds;

    public ImperialWeightMachine(double measuredWeightInPounds){
        this.measuredWeightInPounds = measuredWeightInPounds;
    }

    @Override
    public double getWeightInPounds() {
        return measuredWeightInPounds;
    }
}
