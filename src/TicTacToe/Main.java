package TicTacToe;

import TicTacToe.Model.GameStatus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player 1 name: ");
        String input1 = sc.nextLine();
        System.out.println("Enter player 2 name: ");
        String input2 = sc.nextLine();

        TicTacToeGame newGame = new TicTacToeGame();
        newGame.initializeGame(input1, input2);
        GameStatus currStatus = newGame.startGame();
        switch (currStatus) {
            case WIN:
                System.out.println(newGame.winner.getName()+" won the game!");
                break;
            case DRAW:
                System.out.println("Draw!");
                break;
            default:
                System.out.println("Invalid input, game has to be ended!");
                break;
        }
    }
}
