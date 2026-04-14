package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int numberOfDice;
    int min=1;
    int max=6;

    public Dice(int numberOfDice){
        this.numberOfDice=numberOfDice;
    }

    public int rollDice(){
        int numSum=0;
        int numDice=0;

        while(numDice<numberOfDice){
            numSum+= ThreadLocalRandom.current().nextInt(min,max+1);
            numDice++;
        }

        return numSum;
    }
}
