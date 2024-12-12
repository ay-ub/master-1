/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpalgo05;
 
 public class BoyerMooreSearch {
    public static void bm(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] badChar = createBadCharacterTable(pattern);

        int shift = 0;
        while (shift <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
            }

            if (j < 0) {
                System.out.println("Pattern found at index: " + shift);
                shift += (shift + m < n) ? m - badChar[text.charAt(shift + m)] : 1;
            } else {
                shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
            }
        }
    }

    private static int[] createBadCharacterTable(String pattern) {
        int[] badChar = new int[256];
        for (int i = 0; i < 256; i++) {
            badChar[i] = -1;
        }
        for (int i = 0; i < pattern.length(); i++) {
            badChar[pattern.charAt(i)] = i;
        }
        return badChar;
    }
}