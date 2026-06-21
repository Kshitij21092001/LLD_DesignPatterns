package AdapterDesignPattern.Adapter;

import AdapterDesignPattern.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
    private WeightMachine machine;

    public WeightMachineAdapterImpl(WeightMachine machine) {
        this.machine = machine;
    }

    @Override
    public double getWeightInKG() {
        double poundWeight=machine.getWeightInPounds();
        return poundWeight*0.45;
    }
}
