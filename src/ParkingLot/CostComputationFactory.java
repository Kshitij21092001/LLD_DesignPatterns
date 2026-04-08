package ParkingLot;

import java.util.Objects;

public class CostComputationFactory {
    public PricingStrategy getCostComputation(String str){
        PricingStrategy temp=null;
        if(Objects.equals(str, "hourly"))temp=new HourlyPricingStrategy();
        if(Objects.equals(str, "minute"))temp=new MinutePricingStrategy();
        return temp;
    }
}
