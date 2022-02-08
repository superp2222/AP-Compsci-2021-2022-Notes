import java.util.Locale;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class TwoDimensionArraysHW {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {3, 4, 5}, {6, 7, 8}};
        boolean terminate = false;
        for (int r = 0; r < arr.length && !terminate; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                int num = arr[r][c];
                int count = 0;
                for (int row = 0; row < arr.length; row++) {
                    for (int col = 0; col < arr[0].length; col++) {
                        if (num == arr[row][col]) {
                            count++;
                        }
                    }
                }
                if (count > 1) {
                    System.out.println("Contains Duplicates.");
                    terminate = true;
                }
                if (r == arr.length - 1 && c == arr.length - 1) {
                    System.out.println("No Duplicates.");
                    break;
                }
            }
        }
    }
}