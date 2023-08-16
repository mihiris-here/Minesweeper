package com.company;

import java.util.*;

public class Board {

    //Easy - 10 flags 8 rows 10 cols
    //Medium - 40 flags 14 rows 18 cols
    //Medium -99 flags 20 rows 24 cols

    private String b_level;
    private int[][] theBoard;



    public Board(int mode){                          //basically the constructor
        String[] level = {"Easy","Medium","Hard"};
        int va = mode;
        this.b_level = level[va-1];
        switch (va) {
            case 1:
                theBoard = getTheBoard(8,10,10);
                //printBoard();
                break;
            case 2:
                theBoard = getTheBoard(14,18,40);
                //printBoard();
                break;
            case 3:
                theBoard = getTheBoard(20,24,99);
                //printBoard();
                break;
        }
        System.out.println("Let the "+b_level+" Games Begin!!");
    }

    public void printBoard(){
        for (int i = 0; i < theBoard.length; i++) {
            for (int j = 0; j < theBoard[0].length; j++) {
                System.out.print(theBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] getBoard(){
        return theBoard;
    }

    private int[][] getTheBoard(int rows, int cols,int flags) {
        theBoard = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < flags; i++) {                       //set the mines
            int r = rand.nextInt(0,rows-1);
            int c = rand.nextInt(0,cols-1);
            while(theBoard[r][c]!=0){
                r = rand.nextInt(0,rows-1);
                c = rand.nextInt(0,cols-1);
            }
            theBoard[r][c]= 9;
        }
        for (int i = 0; i < rows; i++) {                        //calculate the number of mines in each set
            for (int j = 0; j < cols; j++) {
                if (theBoard[i][j]!= 9) {
                    ArrayList<Integer> vals = new ArrayList<>();
                    int[][] moves =
                            {{i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},
                                    {i, j - 1}, {i, j + 1},
                                    {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1}};
                    for (int[] m  : moves) {
                        try {
                            vals.add(theBoard[m[0]][m[1]]);
                        } catch (Exception e) {
                        }
                    }
                    int k = 0;
                    for (int l = 0; l < vals.size(); l++) {
                        if (9 == vals.get(l)) k = k + 1;
                    }
                    theBoard[i][j] = k;
                }
            }
        }
        
        return theBoard;
    }

}
