import java.util.stream.IntStream;

public class ArraysHW {
    public static void main(String[] args) {
        //Q16
        int[] arr = {1,2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        for(int i = 0; i<arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == arr[i] && j != i) System.out.println("Duplicate found: "+arr[i]);
            }
        }
    }
}
