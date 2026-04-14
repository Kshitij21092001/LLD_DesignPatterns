package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int boardSize,int numSnakes,int numLadders) {
        createBoard(boardSize);
        addSnakesLadder(cells,numSnakes,numLadders);
    }

    private void createBoard(int boardSize){
        cells = new Cell[boardSize][boardSize];

        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                cells[i][j]=new Cell();
            }
        }
    }

    private void addSnakesLadder(Cell[][] cells,int numSnakes,int numLadders){
        while(numSnakes>0){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1 );
            int end = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1 );
            if(start<=end){
                continue;
            }

            Jump snakeJump=new Jump(start,end);
            Cell tempCell = getCell(snakeJump.start);
            tempCell.setJump(snakeJump);

            numSnakes--;
        }

        while(numLadders>0){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1 );
            int end = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1 );
            if(start>=end  || getCell(start).jump!=null){
                continue;
            }

            Jump ladderJump = new Jump(start,end);
            Cell tempCell = getCell(ladderJump.start);
            tempCell.setJump(ladderJump);

            numLadders--;
        }
    }

    public Cell getCell(int position){
        int row=position/cells.length;
        int col=position%cells.length;
        return cells[row][col];
    }
}
