package BoardGames;

import java.util.ArrayList;
import java.util.Scanner;

public class Sudoku {
    public static int[][] tester = new int[9][9];
    public static void main(String[] args) {
        String input = "";
        int[][] board = new int[9][9];
        ArrayList<Integer> oneToNine = new ArrayList<Integer>();
        for(int i = 1; i<=9;i++){
            oneToNine.add(i);
        }
        board = startup(board);
        tester = board;
    }

    public static void printboard(String[][] b){
        for(int r = 0; r<b.length;r++){
            for(int c = 0; c<b[0].length;c++){
                System.out.print(b[r][c]+"  ");
            }
            System.out.println();
        }
    }
    public static boolean inRow(int num, int rowselector){
        for(int col=0;col<9;col++){
            if(tester[rowselector][col]==num){
                return true;
            }
        }
        return false;
    }
    public static boolean inCol(int num, int colselector){
        for(int row=0;row<9;row++){
            if(tester[row][colselector]==num){
                return true;
            }
        }
        return false;
    }
    public static boolean inGrid(int num,int rowselector, int colselector){
        int row = rowselector - rowselector%3; //remove remainder = starting place
        int col = colselector - colselector%3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(tester[i][j]==num){
                    return true;
                }
            }
        }
        return false;
    }
    public static int[][] startup(int[][] board){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Sudoku Solver");
        System.out.println("Sudoku is a puzzle game where you order numbers from 1 to 9");
        System.out.println("on a 9x9 board. However, the number must occur once");
        System.out.println("In each row, column, and each of the nine 3x3 areas of the board");
        System.out.println("This program will attempt to solve any sudoku puzzle you give\n");
        System.out.println("Please enter your sudoku puzzle below");
        int rowselector = -1;
        int colselector = -1;
        boolean exit = false;
        while(!exit) {
            System.out.println("Choose which row you'd like to choose");
            while (rowselector < 0 || rowselector > 9) {
                rowselector = scan.nextInt() - 1;
                if (rowselector < 0 || rowselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Choose which column you'd like to choose");
            while (colselector < 0 || colselector > 9) {
                colselector = scan.nextInt() - 1;
                if (colselector < 0 || colselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Selected Row: " + (rowselector + 1));
            System.out.println("Selected Col: " + (colselector + 1));
            System.out.println("What would you like to fill here?");
            int fillnum = -1;
            while (fillnum < 0 || fillnum > 9) {
                fillnum = scan.nextInt();
                if (fillnum < 0 || fillnum > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            board[rowselector][colselector] = fillnum;
            System.out.println("Done. Are you finished entering?");
            System.out.println("Enter 1 for yes and 2 for no");
            int finishedyet = -1;
            while (finishedyet < 1 || finishedyet > 2) {
                finishedyet = scan.nextInt();
                if (finishedyet < 1 || finishedyet > 2) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            if(finishedyet == 1) exit = true;
            else exit = false;
        }
        return board;
    }
}
