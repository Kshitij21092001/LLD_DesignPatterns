package SnakeAndLadder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to SnakesAndLadder, please enter both the player name one by one");
        String player1;
        String player2;
        Scanner sc = new Scanner(System.in);
        player1=sc.nextLine();
        player2=sc.nextLine();

        Game newGame = new Game(player1,player2);
        newGame.playGame();
        System.out.println("Thanks for playing!");
    }
}
