// Jose Lopez
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Program6 {
    public static void main(String[] args) {
        
        int arraySize = 20000;
        int[] bubbleSortArray = new int[arraySize];
        int[] selectionSortArray = new int[arraySize];
        ArrayList<Integer> arrayListIntegers = new ArrayList<>();

        
        String[] bubbleSortStrings = new String[arraySize];
        String[] selectionSortStrings = new String[arraySize];
        ArrayList<String> arrayListStrings = new ArrayList<>();

        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("NumbersInFile.txt"));
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                bubbleSortArray[index] = num;
                selectionSortArray[index] = num;
                arrayListIntegers.add(num);

                String str = line; 
                bubbleSortStrings[index] = str;
                selectionSortStrings[index] = str;
                arrayListStrings.add(str);

                index++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        long startTimeBubbleSortInt = System.nanoTime();
        bubbleSort(bubbleSortArray);
        long endTimeBubbleSortInt = System.nanoTime();
        long durationBubbleSortInt = endTimeBubbleSortInt - startTimeBubbleSortInt;

        
        long startTimeSelectionSortInt = System.nanoTime();
        selectionSort(selectionSortArray);
        long endTimeSelectionSortInt = System.nanoTime();
        long durationSelectionSortInt = endTimeSelectionSortInt - startTimeSelectionSortInt;

        
        long startTimeBubbleSortStr = System.nanoTime();
        bubbleSort(bubbleSortStrings);
        long endTimeBubbleSortStr = System.nanoTime();
        long durationBubbleSortStr = endTimeBubbleSortStr - startTimeBubbleSortStr;

        
        long startTimeSelectionSortStr = System.nanoTime();
        selectionSort(selectionSortStrings);
        long endTimeSelectionSortStr = System.nanoTime();
        long durationSelectionSortStr = endTimeSelectionSortStr - startTimeSelectionSortStr;

        
        long startTimeCollectionsSort = System.nanoTime();
        Collections.sort(arrayListStrings);
        long endTimeCollectionsSort = System.nanoTime();
        long durationCollectionsSort = endTimeCollectionsSort - startTimeCollectionsSort;

        
        try {
            FileWriter writer = new FileWriter("results.txt");
            writer.write("Number of Integers: " + arraySize + "\n");
            writer.write("Bubble Sort (Integers) Time: " + durationBubbleSortInt + " nanoseconds\n");
            writer.write("Selection Sort (Integers) Time: " + durationSelectionSortInt + " nanoseconds\n");
            writer.write("Number of Strings: " + arraySize + "\n");
            writer.write("Bubble Sort (Strings) Time: " + durationBubbleSortStr + " nanoseconds\n");
            writer.write("Selection Sort (Strings) Time: " + durationSelectionSortStr + " nanoseconds\n");
            writer.write("Collections.sort() (Strings) Time: " + durationCollectionsSort + " nanoseconds\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    
    public static void bubbleSort(String[] arr) {
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

    
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    
    public static void selectionSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
