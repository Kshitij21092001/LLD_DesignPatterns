package SnakeAndLadder;

public class Player {
    String name;
    int currPosition;

    public Player(String name){
        this.name=name;
        this.currPosition=0;
    }

    public String getName(){
        return name;
    }

    public int getCurrPosition(){
        return currPosition;
    }

    public void setCurrPosition(int currPosition){
        this.currPosition=currPosition;
    }
}
