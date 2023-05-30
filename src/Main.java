/**
 * @author Max Day
 * Created At: 2023/05/30
 */

import javax.swing.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        String[] sArr = new String[5];
        Arrays.setAll(sArr, i -> JOptionPane.showInputDialog("Enter a String")); // this is so cool I absolutely love it

        System.out.printf("The original array is: %s\b\b", toString(sArr));
        Arrays.sort(sArr); // don't blame me its just better xD. I will put a sort method in comments at the end to show how it would work
        System.out.printf("\nThe sorted array is: %s\b\b", toString(sArr));

        String search = JOptionPane.showInputDialog("Enter the word you would like to search for");
        int index = Arrays.binarySearch(sArr, search); // I have written my own at the bottom in comments just to show ik what's going on
        if (index >= 0)// could have made this a one-liner but printf is a bit finicky
            System.out.printf("\nThe word %s was found at index %d, the string was: %s", search, index, sArr[index]);
        else System.out.printf("The string %s was not found", search);

    }

    public static String toString(String[] sArr) { // this is disgustingly efficient
        StringBuilder sb = new StringBuilder();
        Arrays.stream(sArr).forEach(value -> sb.append(value).append(", "));
        return sb.toString();
    }

    public static void print(String[] sArr) {
        Arrays.stream(sArr).map(s -> s + ", ").forEach(System.out::print); // The arrays class is the coolest shit ever
    }

    public static void bubbleSortArr(String[] arr) { //using for each - best
        int n = arr.length;
        IntStream.range(0, n - 1).flatMap(i -> IntStream.range(0, n - i - 1)).filter(j -> arr[j].compareTo(arr[j + 1]) > 0).forEachOrdered(j -> {
            String temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        });
    }

    public static void bubbleSortArrNormal(String[] arr) { // the sorting for normal people
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int binSearch(String[] sArr, String search) { // this is not the most elegant but it works ig
        int left = 0;
        int right = sArr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = search.compareTo(sArr[mid]);
            if (compareResult == 0) return mid;
            else if (compareResult < 0) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }


}
