package SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private Board board;
    private Dice dice;
    Deque<Player> players;
    Player winner;

    public Game(String player1, String player2) {
        initializeGame(player1, player2);
    }

    public void initializeGame(String player1, String player2) {
        board = new Board(10,6,8);
        dice = new Dice(2);
        players = new LinkedList<Player>();
        winner = null;
        addPlayers(player1,player2);
    }

    public void addPlayers(String player1, String player2) {
        players.add(new Player(player1));
        players.add(new Player(player2));
    }

    public void playGame(){
        while(winner == null){
            Player currentPlayer = players.pollFirst();

            System.out.println("It's "+currentPlayer.getName()+"'s turn, current position is"+currentPlayer.getCurrPosition());
            System.out.println("Press number 1 to roll the dice, press 0 to end the game");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if(input == 0){
                System.out.println("Thanks for playing! Game is ended");
                System.exit(0);
            }
            if(input == 1){
                int newPosition = currentPlayer.getCurrPosition()+dice.rollDice();
                newPosition = jumpCheck(newPosition);
                currentPlayer.setCurrPosition(newPosition);
            }

            if(currentPlayer.getCurrPosition()>board.cells.length*board.cells.length-1){
                winner=currentPlayer;
                break;
            }
            System.out.println(currentPlayer.getName()+"'s current position after turn is "+currentPlayer.getCurrPosition());
            players.addLast(currentPlayer);
        }
        System.out.println("Winner is "+winner.getName());
    }

    public int jumpCheck(int position){
        if(position>board.cells.length*board.cells.length-1){
            return position;
        }

        Cell currentCell = board.getCell(position);
        if(currentCell.jump!=null && currentCell.jump.start==position){
            if(currentCell.jump.start>currentCell.jump.end){
                System.out.println("Jump because of Snake");
            }
            else{
                System.out.println("Jump because of Ladder");
            }
            return currentCell.jump.end;
        }
        return position;
    }
}
