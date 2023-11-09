//Jose Lopez
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Program7 {
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
        // Bubble sort logic for integers
        // ...
    }

    public static void bubbleSort(String[] arr) {
        // Bubble sort logic for strings
        // ...
    }

    public static void selectionSort(int[] arr) {
        // Selection sort logic for integers
        // ...
    }

    public static void selectionSort(String[] arr) {
        // Selection sort logic for strings
        // ...
    }
}
