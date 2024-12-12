/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tpalgo05;
 
 
//public class TpAlgo05 {
 import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TpAlgo05  {
    public static void main(String[] args) {
        // User input for the search word
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word to search: ");
        String pattern = scanner.nextLine();

        if (pattern.isEmpty()) {
            System.out.println("Error: Search word cannot be empty.");
            return;
        }

        // Generate files with different sizes
        createTestFiles();

        // Files of different sizes
        String[] fileNames = {"small.txt", "medium.txt", "large.txt"};

        // Data to store performance results
        List<PerformanceChart> performanceResults = new ArrayList<>();

        System.out.println("\nPerformance Results:");

        for (String fileName : fileNames) {
            String text = readFile(fileName);

            if (text == null || text.isEmpty()) {
                System.out.println("Error reading file: " + fileName);
                continue;
            }

            System.out.println("\nProcessing file: " + fileName);

            // Measure execution times
            long naiveTime = measureExecutionTime(() -> NaiveSearch.naif(text, pattern));
            long kmpTime = measureExecutionTime(() -> KMPSearch.kmp(text, pattern));
            long bmTime = measureExecutionTime(() -> BoyerMooreSearch.bm(text, pattern));
            long rkTime = measureExecutionTime(() -> RKSearch.rk(text, pattern));

            // Add results to the list
            performanceResults.add(new PerformanceChart(fileName, naiveTime, rkTime, kmpTime, bmTime));

            // Console output for this file
            System.out.printf("File: %s (Size: %d lines)%n", fileName, getFileSize(fileName));
            System.out.printf("  Naive Search: %d ns%n", naiveTime);
            System.out.printf("  KMP Search: %d ns%n", kmpTime);
            System.out.printf("  Boyer-Moore Search: %d ns%n", bmTime);
            System.out.printf("  RK Search: %d ns%n", rkTime);
        }

        // Create a dataset for the chart
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries naiveSeries = new XYSeries("Naive");
        XYSeries kmpSeries = new XYSeries("KMP");
        XYSeries bmSeries = new XYSeries("Boyer-Moore");
        XYSeries rkSeries = new XYSeries("RK");

        for (PerformanceChart result : performanceResults) {
            int fileSize = getFileSize(result.getFileName());
            naiveSeries.add(fileSize, result.getNaiveTime());
            kmpSeries.add(fileSize, result.getKmpTime());
            bmSeries.add(fileSize, result.getBmTime());
            rkSeries.add(fileSize, result.getRkTime());
        }

        dataset.addSeries(naiveSeries);
        dataset.addSeries(kmpSeries);
        dataset.addSeries(bmSeries);
        dataset.addSeries(rkSeries);

        // Create the chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Pattern Search Performance",
                "File Size (lines)",
                "Execution Time (ns)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        // Display the chart in a JFrame
        JFrame frame = new JFrame("Performance Comparison");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }

    private static long measureExecutionTime(Runnable algorithm) {
        long start = System.nanoTime();
        algorithm.run();
        return System.nanoTime() - start;
    }

    private static String readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString().trim();
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName + " - " + e.getMessage());
            return null;
        }
    }

    private static int getFileSize(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        } catch (IOException e) {
            System.out.println("Error getting file size: " + fileName + " - " + e.getMessage());
            return 0;
        }
    }

    private static void createTestFiles() {
        try {
            // Create small.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("small.txt"))) {
                writer.write("This is a small file with a simple pattern.\n");
            }

            // Create medium.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("medium.txt"))) {
                for (int i = 0; i < 1000; i++) {
                    writer.write("This is line " + i + " with some repetitive text. pattern.\n");
                }
            }

            // Create large.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("large.txt"))) {
                for (int i = 0; i < 100000; i++) {
                    writer.write("This is line " + i + " with some repetitive text. pattern.\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error creating test files: " + e.getMessage());
        }
    }
}