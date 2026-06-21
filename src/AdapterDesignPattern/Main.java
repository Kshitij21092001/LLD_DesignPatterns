package AdapterDesignPattern;

import AdapterDesignPattern.Adaptee.ImperialWeightMachine;
import AdapterDesignPattern.Adaptee.WeightMachine;
import AdapterDesignPattern.Adapter.WeightMachineAdapter;
import AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Adapter Design Pattern====Demo");
        Scanner input = new Scanner(System.in);
        System.out.println("Put weight in pounds: ");
        double weight=input.nextDouble();

        WeightMachine machine=new ImperialWeightMachine(weight);
        WeightMachineAdapter adapter=new WeightMachineAdapterImpl(machine);
        System.out.println("Weight in KGs: "+adapter.getWeightInKG());
    }
}
