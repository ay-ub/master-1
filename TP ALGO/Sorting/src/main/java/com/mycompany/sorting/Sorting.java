/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sorting;

import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Ay-ob
 */
public class Sorting extends JFrame {

    public Sorting(String title) {
        super(title);
    }

   
    static public void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    
    static public int getRandomNumber(int maxValue) {
        Random rand = new Random();
        return rand.nextInt(maxValue);
    }

    
    static public void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNumber(arr.length);
        }
    }

  
    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    
    static public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    
    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Convert nanoseconds to seconds
    public static double toSeconds(double nanoSeconds) {
        return nanoSeconds / 1_000_000_000.0;
    }

    // Create a dataset for the graph
    private static DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset collectData = new DefaultCategoryDataset();
        final int[] SIZE = {10, 100, 1000, 10000 , 100000};

        for (int size : SIZE) {
            int[] table = new int[size];
            fillArray(table);

            // Selection Sort
            long startSelectionSort = System.nanoTime();
            selectionSort(table);
            long endSelectionSort = System.nanoTime();
            double selectionSortTime = toSeconds(endSelectionSort - startSelectionSort);
            collectData.addValue(selectionSortTime, "Selection Sort", String.valueOf(size));

            // Quick Sort
            fillArray(table);
            long startQuickSort = System.nanoTime();
            quickSort(table, 0, table.length - 1);
            long endQuickSort = System.nanoTime();
            double quickSortTime = toSeconds(endQuickSort - startQuickSort);
            collectData.addValue(quickSortTime, "Quick Sort", String.valueOf(size));

            // Merge Sort
            fillArray(table);
            long startMergeSort = System.nanoTime();
            mergeSort(table, 0, table.length - 1);
            long endMergeSort = System.nanoTime();
            double mergeSortTime = toSeconds(endMergeSort - startMergeSort);
            collectData.addValue(mergeSortTime, "Merge Sort", String.valueOf(size));
        }

        return collectData;
    }

   
    private static JFreeChart createChart(DefaultCategoryDataset dataset) {
        return ChartFactory.createLineChart(
                "Sorting Algorithm Complexity",
                "Array Size",
                "Time (Seconds)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    
    private static void showGraph() {
        DefaultCategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        Sorting frame = new Sorting("Sorting Algorithm Complexity Graph");
        frame.setContentPane(chartPanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        showGraph();
    }
}
