package TicTacToe;

import TicTacToe.Model.*;

import java.util.*;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;
    Player winner;

    public void initializeGame(String player1name, String player2name){
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player(player1name, crossPiece);

        PlayingPieceO noughtPiece = new PlayingPieceO();
        Player player2 = new Player(player2name, noughtPiece);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public GameStatus startGame(){
        boolean noWinner=true;

        while(noWinner){
            Player currentPlayer = players.pollFirst();
            board.printBoard();

            List<Pair<Integer,Integer>> freeSpaces = board.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }

            assert currentPlayer != null;
            System.out.println("Player "+currentPlayer.getName()+" please input in row,col format: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            String[] parts =  input.split(",");
            int row=Integer.parseInt(parts[0].trim());
            int col=Integer.parseInt(parts[1].trim());

            if(!board.addPiece(row, col, currentPlayer.getPlayingPiece())){
                System.out.println("Invalid input, please try again");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);

            boolean isWinner=checkForWinner(row,col,currentPlayer.getPlayingPiece().pieceType);
            if(isWinner){
                winner=currentPlayer;
                board.printBoard();
                return GameStatus.WIN;
            }
        }
        return GameStatus.DRAW;
    }

    public boolean checkForWinner(int row, int col,PieceType pieceType ){
        boolean rowMatch=true;
        boolean colMatch=true;
        boolean diagonalMatch=true;
        boolean antiDiagonalMatch=true;

        for(int i=0;i< board.size;i++){
            if(board.board[i][col]==null || board.board[i][col].pieceType!=pieceType){
                colMatch=false;
                break;
            }
        }

        for(int i=0;i< board.size;i++){
            if(board.board[row][i]==null || board.board[row][i].pieceType!=pieceType){
                rowMatch=false;
                break;
            }
        }

        for(int i=0,j=0;i< board.size;i++,j++){
            if(board.board[i][j]==null || board.board[i][j].pieceType!=pieceType){
                diagonalMatch=false;
                break;
            }
        }

        for(int i=0,j=board.size-1;i< board.size;i++,j--){
            if(board.board[i][j]==null || board.board[i][j].pieceType!=pieceType){
                antiDiagonalMatch=false;
                break;
            }
        }
        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
