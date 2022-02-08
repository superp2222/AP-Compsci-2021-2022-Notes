package BoardGames;

import java.util.ArrayList;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        String[][] p1board = new String[10][10];
        for(int r = 0; r<p1board.length;r++){
            for(int c = 0; c<p1board[0].length;c++){
                p1board[r][c] = "-";
            }
        }
        String[][] p2board = new String[10][10];
        for(int r = 0; r<p2board.length;r++){
            for(int c = 0; c<p2board[0].length;c++){
                p2board[r][c] = "-";
            }
        }
        startingsequence();
        playerplaceships(p1board, 1);
        System.out.println("Final Layout: ");
        printboard(p1board);
        System.out.println("Enter any value to continue to player 2");
        input = scan.next();
        playerplaceships(p2board, 2);
        System.out.println("Final Layout: ");
        printboard(p2board);
        System.out.println("Enter any value to continue to game start screen");
        input = scan.next();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("----------------");
        System.out.println("| BOTH PLAYERS |");
        System.out.println("----------------");
        System.out.println("When targeting the other player, if you hit, an H will appear on your target board");
        System.out.println("If you miss, an M will appear instead");
        System.out.println("If any of your ships were hit, they will be marked X in the spot where they were hit");
        System.out.println("------------");
        System.out.println("| PLAYER 1 |");
        System.out.println("------------");
        System.out.println("Enter any value to start the game");
        input = scan.next();

        game(p1board,p2board);


    }
    public static boolean checkoverlap(int smallnum, int bignum,int otherconstant ,String[][] grid, boolean isRow){
        if(isRow){
            for(int i = smallnum; i<= bignum; i++){
                if(grid[i][otherconstant].equals("S")) return true;
            }
        }else{
            for(int i = smallnum; i<= bignum; i++){
                if(grid[otherconstant][i].equals("S")) return true;
            }
        }
        return false;
    }
    public static String[][] playerplaceships(String[][] p1board, int player){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------");
        System.out.println("| PLAYER "+player+" |");
        System.out.println("------------");
        for(int r = 0; r<p1board.length;r++){
            for(int c = 0; c<p1board[0].length;c++){
                System.out.print(p1board[r][c]+"  ");
            }
            System.out.println();
        }
        System.out.println("Please begin placing ships");
        System.out.println("NOW PLACING: CARRIER (5 SPACES)");
        int rowselector = -1;
        int colselector = -1;
        System.out.println("Choose which row you'd like to place your ship");
        while(rowselector < 0 || rowselector > 9){
            rowselector = scan.nextInt()-1;
            if(rowselector < 0 || rowselector > 9){
                System.out.println("Invalid Choice, Try Again?");
            }
        }
        System.out.println("Selected Row: "+(rowselector+1));
        System.out.println("Choose which column you'd like to place your ship");
        while(colselector < 0 || colselector > 9){
            colselector = scan.nextInt()-1;
            if(colselector < 0 || colselector > 9){
                System.out.println("Invalid Choice, Try Again?");
            }
        }
        System.out.println("Selected Column: "+(colselector+1));
        ArrayList<Integer> acceptableanswers = new ArrayList<Integer>();
        int counter = 0;
        int rowdisplay = rowselector-4;
        boolean overlappingship = false;
        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowdisplay, rowselector,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 4 Rows Up");
                acceptableanswers.add(1);
                counter++;
            }
        }
        rowdisplay = rowselector+4;
        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowselector, rowdisplay,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 4 Rows Down");
                acceptableanswers.add(2);
                counter++;
            }
        }

        int coldisplay = colselector-4;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(coldisplay, colselector,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 4 Cols Left");
                acceptableanswers.add(3);
                counter++;
            }
        }
        coldisplay = colselector+4;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(colselector, coldisplay,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 4 Cols Right");
                acceptableanswers.add(4);
                counter++;
            }
        }
        for(int i = 0; i<acceptableanswers.size(); i++){
            if(acceptableanswers.get(i) == 1) System.out.println("Press 1 to place ship upwards");
            else if(acceptableanswers.get(i) == 2) System.out.println("Press 2 to place ship downwards");
            else if(acceptableanswers.get(i) == 3) System.out.println("Press 3 to place ship left");
            else if(acceptableanswers.get(i) == 4) System.out.println("Press 4 to place ship right");
        }
        int playerresponse = 0;
        while(!acceptableanswers.contains(playerresponse)){
            playerresponse = scan.nextInt();
            if(!acceptableanswers.contains(playerresponse)){
                System.out.println("Invalid Choice, Try Again?");
            }
        }
        if(playerresponse == 1){
            rowdisplay = rowselector-4;
            for(int i = rowdisplay;i<=rowselector;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 2){
            rowdisplay = rowselector+4;
            for(int i = rowselector;i<=rowdisplay;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 3){
            coldisplay = colselector-4;
            for(int i = coldisplay;i<=colselector;i++){
                p1board[rowselector][i] = "S";
            }
        }
        if(playerresponse == 4){
            coldisplay = colselector+4;
            for(int i = colselector;i<=coldisplay;i++){
                p1board[rowselector][i] = "S";
            }
        }
        System.out.println("Your Current Board:");
        printboard(p1board);
        //BATTLESHIP SECTION
        System.out.println("NOW PLACING: BATTLESHIP (4 SPACES)");
         rowselector = -1;
         colselector = -1;
        do {
            System.out.println("Choose which row you'd like to place your ship");
            rowselector = -1;
            colselector = -1;
            while (rowselector < 0 || rowselector > 9) {
                rowselector = scan.nextInt() - 1;
                if (rowselector < 0 || rowselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Selected Row: " + (rowselector + 1));
            System.out.println("Choose which column you'd like to place your ship");
            while (colselector < 0 || colselector > 9) {
                colselector = scan.nextInt() - 1;
                if (colselector < 0 || colselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Selected Column: " + (colselector + 1));
            if(p1board[rowselector][colselector].contains("S")) System.out.println("A ship is already there!");
        }while(p1board[rowselector][colselector].contains("S"));

        acceptableanswers = new ArrayList<Integer>();
        counter = 0;
        rowdisplay = rowselector-3;

        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowdisplay, rowselector,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 3 Rows Up");
                acceptableanswers.add(1);
                counter++;
            }
        }
        rowdisplay = rowselector+3;

        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowselector, rowdisplay,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 3 Rows Down");
                acceptableanswers.add(2);
                counter++;
            }
        }

        coldisplay = colselector-3;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(coldisplay, colselector,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 3 Cols Left");
                acceptableanswers.add(3);
                counter++;
            }
        }
        coldisplay = colselector+3;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(colselector, coldisplay,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 3 Cols Right");
                acceptableanswers.add(4);
                counter++;
            }
        }
        for(int i = 0; i<acceptableanswers.size(); i++){
            if(acceptableanswers.get(i) == 1) System.out.println("Press 1 to place ship upwards");
            else if(acceptableanswers.get(i) == 2) System.out.println("Press 2 to place ship downwards");
            else if(acceptableanswers.get(i) == 3) System.out.println("Press 3 to place ship left");
            else if(acceptableanswers.get(i) == 4) System.out.println("Press 4 to place ship right");
        }
        playerresponse = 0;
        while(!acceptableanswers.contains(playerresponse)){
            playerresponse = scan.nextInt();
            if(!acceptableanswers.contains(playerresponse)){
                System.out.println("Invalid Choice, Try Again?");
            }
        }
        if(playerresponse == 1){
            rowdisplay = rowselector-3;
            for(int i = rowdisplay;i<=rowselector;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 2){
            rowdisplay = rowselector+3;
            for(int i = rowselector;i<=rowdisplay;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 3){
            coldisplay = colselector-3;
            for(int i = coldisplay;i<=colselector;i++){
                p1board[rowselector][i] = "S";
            }
        }
        if(playerresponse == 4){
            coldisplay = colselector+3;
            for(int i = colselector;i<=coldisplay;i++){
                p1board[rowselector][i] = "S";
            }
        }
        System.out.println("Your Current Board:");
        printboard(p1board);
        //CRUISER SECTION
        System.out.println("NOW PLACING: CRUISER (3 SPACES)");
        rowselector = -1;
        colselector = -1;
        do {
            System.out.println("Choose which row you'd like to place your ship");
            rowselector = -1;
            colselector = -1;
            while (rowselector < 0 || rowselector > 9) {
                rowselector = scan.nextInt() - 1;
                if (rowselector < 0 || rowselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Selected Row: " + (rowselector + 1));
            System.out.println("Choose which column you'd like to place your ship");
            while (colselector < 0 || colselector > 9) {
                colselector = scan.nextInt() - 1;
                if (colselector < 0 || colselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Selected Column: " + (colselector + 1));
            if(p1board[rowselector][colselector].contains("S")) System.out.println("A ship is already there!");
        }while(p1board[rowselector][colselector].contains("S"));

        acceptableanswers = new ArrayList<Integer>();
        counter = 0;
        rowdisplay = rowselector-2;

        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowdisplay, rowselector,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 2 Rows Up");
                acceptableanswers.add(1);
                counter++;
            }
        }
        rowdisplay = rowselector+2;

        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowselector, rowdisplay,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 2 Rows Down");
                acceptableanswers.add(2);
                counter++;
            }
        }

        coldisplay = colselector-2;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(coldisplay, colselector,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 2 Cols Left");
                acceptableanswers.add(3);
                counter++;
            }
        }
        coldisplay = colselector+2;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(colselector, coldisplay,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 2 Cols Right");
                acceptableanswers.add(4);
                counter++;
            }
        }
        for(int i = 0; i<acceptableanswers.size(); i++){
            if(acceptableanswers.get(i) == 1) System.out.println("Press 1 to place ship upwards");
            else if(acceptableanswers.get(i) == 2) System.out.println("Press 2 to place ship downwards");
            else if(acceptableanswers.get(i) == 3) System.out.println("Press 3 to place ship left");
            else if(acceptableanswers.get(i) == 4) System.out.println("Press 4 to place ship right");
        }
        playerresponse = 0;
        while(!acceptableanswers.contains(playerresponse)){
            playerresponse = scan.nextInt();
            if(!acceptableanswers.contains(playerresponse)){
                System.out.println("Invalid Choice, Try Again?");
            }
        }
        if(playerresponse == 1){
            rowdisplay = rowselector-2;
            for(int i = rowdisplay;i<=rowselector;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 2){
            rowdisplay = rowselector+2;
            for(int i = rowselector;i<=rowdisplay;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 3){
            coldisplay = colselector-2;
            for(int i = coldisplay;i<=colselector;i++){
                p1board[rowselector][i] = "S";
            }
        }
        if(playerresponse == 4){
            coldisplay = colselector+2;
            for(int i = colselector;i<=coldisplay;i++){
                p1board[rowselector][i] = "S";
            }
        }
        System.out.println("Your Current Board:");
        printboard(p1board);
        //SUBMARINE SECTION
        System.out.println("NOW PLACING: SUMBARINE (3 SPACES)");
        rowselector = -1;
        colselector = -1;
        do {
            System.out.println("Choose which row you'd like to place your ship");
            rowselector = -1;
            colselector = -1;
            while (rowselector < 0 || rowselector > 9) {
                rowselector = scan.nextInt() - 1;
                if (rowselector < 0 || rowselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Selected Row: " + (rowselector + 1));
            System.out.println("Choose which column you'd like to place your ship");
            while (colselector < 0 || colselector > 9) {
                colselector = scan.nextInt() - 1;
                if (colselector < 0 || colselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Selected Column: " + (colselector + 1));
            if(p1board[rowselector][colselector].contains("S")) System.out.println("A ship is already there!");
        }while(p1board[rowselector][colselector].contains("S"));

        acceptableanswers = new ArrayList<Integer>();
        counter = 0;
        rowdisplay = rowselector-2;

        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowdisplay, rowselector,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 2 Rows Up");
                acceptableanswers.add(1);
                counter++;
            }
        }
        rowdisplay = rowselector+2;

        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowselector, rowdisplay,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 2 Rows Down");
                acceptableanswers.add(2);
                counter++;
            }
        }

        coldisplay = colselector-2;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(coldisplay, colselector,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 2 Cols Left");
                acceptableanswers.add(3);
                counter++;
            }
        }
        coldisplay = colselector+2;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(colselector, coldisplay,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 2 Cols Right");
                acceptableanswers.add(4);
                counter++;
            }
        }
        for(int i = 0; i<acceptableanswers.size(); i++){
            if(acceptableanswers.get(i) == 1) System.out.println("Press 1 to place ship upwards");
            else if(acceptableanswers.get(i) == 2) System.out.println("Press 2 to place ship downwards");
            else if(acceptableanswers.get(i) == 3) System.out.println("Press 3 to place ship left");
            else if(acceptableanswers.get(i) == 4) System.out.println("Press 4 to place ship right");
        }
        playerresponse = 0;
        while(!acceptableanswers.contains(playerresponse)){
            playerresponse = scan.nextInt();
            if(!acceptableanswers.contains(playerresponse)){
                System.out.println("Invalid Choice, Try Again?");
            }
        }
        if(playerresponse == 1){
            rowdisplay = rowselector-2;
            for(int i = rowdisplay;i<=rowselector;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 2){
            rowdisplay = rowselector+2;
            for(int i = rowselector;i<=rowdisplay;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 3){
            coldisplay = colselector-2;
            for(int i = coldisplay;i<=colselector;i++){
                p1board[rowselector][i] = "S";
            }
        }
        if(playerresponse == 4){
            coldisplay = colselector+2;
            for(int i = colselector;i<=coldisplay;i++){
                p1board[rowselector][i] = "S";
            }
        }
        System.out.println("Your Current Board:");
        printboard(p1board);
        //DESTROYER SECTION
        System.out.println("NOW PLACING: DESTROYER (2 SPACES)");
        rowselector = -1;
        colselector = -1;
        do {
            System.out.println("Choose which row you'd like to place your ship");
            rowselector = -1;
            colselector = -1;
            while (rowselector < 0 || rowselector > 9) {
                rowselector = scan.nextInt() - 1;
                if (rowselector < 0 || rowselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Selected Row: " + (rowselector + 1));
            System.out.println("Choose which column you'd like to place your ship");
            while (colselector < 0 || colselector > 9) {
                colselector = scan.nextInt() - 1;
                if (colselector < 0 || colselector > 9) {
                    System.out.println("Invalid Choice, Try Again?");
                }
            }
            System.out.println("Selected Column: " + (colselector + 1));
            if(p1board[rowselector][colselector].contains("S")) System.out.println("A ship is already there!");
        }while(p1board[rowselector][colselector].contains("S"));

        acceptableanswers = new ArrayList<Integer>();
        counter = 0;
        rowdisplay = rowselector-1;

        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowdisplay, rowselector,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 1 Row Up");
                acceptableanswers.add(1);
                counter++;
            }
        }
        rowdisplay = rowselector+1;

        if(rowdisplay < 10 && rowdisplay >=0){
            overlappingship = checkoverlap(rowselector, rowdisplay,colselector,p1board, true);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 1 Row Down");
                acceptableanswers.add(2);
                counter++;
            }
        }

        coldisplay = colselector-1;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(coldisplay, colselector,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 1 Col Left");
                acceptableanswers.add(3);
                counter++;
            }
        }
        coldisplay = colselector+1;

        if(coldisplay < 10 && coldisplay >=0){
            overlappingship = checkoverlap(colselector, coldisplay,rowselector,p1board, false);
            if(!overlappingship) {
                System.out.println("Available Endpoint: 1 Col Right");
                acceptableanswers.add(4);
                counter++;
            }
        }
        for(int i = 0; i<acceptableanswers.size(); i++){
            if(acceptableanswers.get(i) == 1) System.out.println("Press 1 to place ship upwards");
            else if(acceptableanswers.get(i) == 2) System.out.println("Press 2 to place ship downwards");
            else if(acceptableanswers.get(i) == 3) System.out.println("Press 3 to place ship left");
            else if(acceptableanswers.get(i) == 4) System.out.println("Press 4 to place ship right");
        }
        playerresponse = 0;
        while(!acceptableanswers.contains(playerresponse)){
            playerresponse = scan.nextInt();
            if(!acceptableanswers.contains(playerresponse)){
                System.out.println("Invalid Choice, Try Again?");
            }
        }
        if(playerresponse == 1){
            rowdisplay = rowselector-1;
            for(int i = rowdisplay;i<=rowselector;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 2){
            rowdisplay = rowselector+1;
            for(int i = rowselector;i<=rowdisplay;i++){
                p1board[i][colselector] = "S";
            }
        }
        if(playerresponse == 3){
            coldisplay = colselector-1;
            for(int i = coldisplay;i<=colselector;i++){
                p1board[rowselector][i] = "S";
            }
        }
        if(playerresponse == 4){
            coldisplay = colselector+1;
            for(int i = colselector;i<=coldisplay;i++){
                p1board[rowselector][i] = "S";
            }
        }
        System.out.println("Your Current Board:");
        printboard(p1board);
        return p1board;
    }
    public static void startingsequence(){
        Scanner scan = new Scanner(System.in);
        String input = "";
        System.out.println("Welcome to Battleship");
        System.out.println("----------------");
        System.out.println("| BOTH PLAYERS |");
        System.out.println("----------------");
        System.out.println("|    RULES     |");
        System.out.println("----------------");
        System.out.println();
        System.out.println("The game is played on a 10x10 board");
        System.out.println("Each player has 5 ships");
        System.out.println("Each round, you will fire a shot at the enemy board");
        System.out.println("If you hit a ship, you go again");
        System.out.println("If you miss, your turn ends");
        System.out.println("Be the first to sink the enemy fleet!");
        System.out.println("Enter any value to continue");
        input = scan.next();
        System.out.println("This will be a WWII historical rendition game");
        System.out.println("Player 1 will have the American Navy");
        System.out.println("Player 2 will have the Japanese Navy");
        System.out.println("Your ships are as follows: ");
        System.out.println("------------");
        System.out.println("| PLAYER 1 |");
        System.out.println("------------");
        System.out.println("CARRIER:  ENTERPRISE, 5 SPACES");
        System.out.println("BATTLESHIP:  IOWA, 4 SPACES");
        System.out.println("CRUISER:  BALTIMORE, 3 SPACES");
        System.out.println("SUBMARINE:  ARCHERFISH, 3 SPACES");
        System.out.println("DESTROYER:  LAFFEY, 2 SPACES");
        System.out.println("Enter any value to continue");
        input = scan.next();
        System.out.println("------------");
        System.out.println("| PLAYER 2 |");
        System.out.println("------------");
        System.out.println("CARRIER:  SHINANO, 5 SPACES");
        System.out.println("BATTLESHIP:  YAMATO, 4 SPACES");
        System.out.println("CRUISER:  TAKAO, 3 SPACES");
        System.out.println("SUBMARINE:  I-700, 3 SPACES");
        System.out.println("DESTROYER:  SHIMAKAZE, 2 SPACES");
        System.out.println("Enter any value to continue");
        input = scan.next();
    }
    public static void printboard(String[][] b){
        for(int r = 0; r<b.length;r++){
            for(int c = 0; c<b[0].length;c++){
                System.out.print(b[r][c]+"  ");
            }
            System.out.println();
        }
    }
    public static void game(String[][] player1, String[][] player2){
        Scanner scan = new Scanner(System.in);
        String[][] p1target = new String[10][10];
        fillboard(p1target);
        String[][] p2target = new String[10][10];
        fillboard(p2target);
        boolean overrideplayertwo = false;
        boolean gameover = false;
        boolean redo = true;
        boolean hit = false;
        int rowselector = -1;
        int colselector = -1;
        String input = "";
        boolean firsthit = true;
        while(!gameover){
            //Player 1 section
            hit = true;
            firsthit = true;
            while(hit && !gameover){
                rowselector = -1;
                colselector = -1;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("------------");
                System.out.println("| PLAYER 1 |");
                System.out.println("------------");
                if(firsthit) {
                    System.out.println("Enter any value to reveal board and start round");
                    input = scan.next();
                    firsthit = false;
                }
                System.out.println("Your Board");
                printboard(player1);
                System.out.println("Enemy's Board");
                printboard(p1target);
                redo = true;
                while(redo) {
                    rowselector = -1;
                    colselector = -1;
                    System.out.println("Choose which row you'd like to target");
                    while (rowselector < 0 || rowselector > 9) {
                        rowselector = scan.nextInt() - 1;
                        if (rowselector < 0 || rowselector > 9) {
                            System.out.println("Invalid Choice, Try Again?");
                        }
                    }
                    System.out.println("Selected Row: " + (rowselector + 1));
                    System.out.println("Choose which column you'd like to target");
                    while (colselector < 0 || colselector > 9) {
                        colselector = scan.nextInt() - 1;
                        if (colselector < 0 || colselector > 9) {
                            System.out.println("Invalid Choice, Try Again?");
                        }
                    }
                    if (player2[rowselector][colselector].equals("X") || p1target[rowselector][colselector].equals("M")) {
                        System.out.println("You already shot at that space!");
                    }else {
                        System.out.println("Selected Column: " + (colselector + 1));
                        redo = false;
                    }
                }//redo loop
                if (player2[rowselector][colselector].equals("S")) {
                    System.out.println("Hit!");
                    hit = true;
                    p1target[rowselector][colselector] = "H";
                    player2[rowselector][colselector] = "X";
                    printboard(p1target);
                }else{
                    hit = false;
                    System.out.println("Miss!");
                    p1target[rowselector][colselector] = "M";
                    printboard(p1target);
                    System.out.println("Enter any value to pass to Player 2");
                    input = scan.next();
                }
                gameover = Battleship.checkboard(player2);
                if(gameover){
                    System.out.println("Player 1 Wins!");
                    overrideplayertwo = true;
                }
            }
            //Player 2 Section
            if(!overrideplayertwo){
                hit = true;
                firsthit = true;
                while(hit && !gameover){
                    hit = false;
                    rowselector = -1;
                    colselector = -1;
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("------------");
                    System.out.println("| PLAYER 2 |");
                    System.out.println("------------");
                    if(firsthit) {
                        System.out.println("Enter any value to reveal board and start round");
                        input = scan.next();
                        firsthit = false;
                    }
                    System.out.println("Your Board");
                    printboard(player2);
                    System.out.println("Enemy Board");
                    printboard(p2target);
                    redo = true;
                    while(redo) {
                        rowselector = -1;
                        colselector = -1;
                        System.out.println("Choose which row you'd like to target");
                        while (rowselector < 0 || rowselector > 9) {
                            rowselector = scan.nextInt() - 1;
                            if (rowselector < 0 || rowselector > 9) {
                                System.out.println("Invalid Choice, Try Again?");
                            }
                        }
                        System.out.println("Selected Row: " + (rowselector + 1));
                        System.out.println("Choose which column you'd like to target");
                        while (colselector < 0 || colselector > 9) {
                            colselector = scan.nextInt() - 1;
                            if (colselector < 0 || colselector > 9) {
                                System.out.println("Invalid Choice, Try Again?");
                            }
                        }
                        if (player1[rowselector][colselector].equals("X") || p2target[rowselector][colselector].equals("M")) {
                            System.out.println("You already shot at that space!");
                        }else {
                            System.out.println("Selected Column: " + (colselector + 1));
                            redo = false;
                        }
                    }//redo loop
                    System.out.println("Selected Column: " + (colselector + 1));
                    if (player1[rowselector][colselector].equals("S")) {
                        System.out.println("Hit!");
                        hit = true;
                        p2target[rowselector][colselector] = "H";
                        player1[rowselector][colselector] = "X";
                        printboard(p2target);

                    }else{
                        hit = false;
                        System.out.println("Miss!");
                        p2target[rowselector][colselector] = "M";
                        printboard(p2target);
                        System.out.println("Enter any value to pass to Player 1");
                        input = scan.next();
                    }
                    gameover = Battleship.checkboard(player2);
                    if(gameover){
                        System.out.println("Player 2 Wins!");
                    }
                }
            }
        }


    }
    public static void fillboard(String[][] board){
        for(int r = 0; r<board.length;r++){
            for(int c = 0; c<board[0].length;c++){
                board[r][c] = "-";
            }
        }
    }
    public static boolean checkboard(String[][] board){
         boolean victory = true;
        for(int r = 0; r<board.length;r++){
            for(int c = 0; c<board[0].length;c++){
                if(board[r][c].contains("S")) victory = false;
            }
        }
        return victory;
    }

}
