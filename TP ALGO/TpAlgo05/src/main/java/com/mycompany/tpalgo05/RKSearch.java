/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpalgo05;

 public class RKSearch {
    public static void rk(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int prime = 101; // A prime number for hashing
        int hashPattern = 0;
        int hashText = 0;
        int h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * 256) % prime;
        }
//           Calculate Initial Hashes
        for (int i = 0; i < m; i++) {
            hashPattern = (256 * hashPattern + pattern.charAt(i)) % prime;
            hashText = (256 * hashText + text.charAt(i)) % prime;
        }

        for (int i = 0; i <= n - m; i++) {
            if (hashPattern == hashText) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    System.out.println("Pattern found at index: " + i);
                }
            }

            if (i < n - m) {
                hashText = (256 * (hashText - text.charAt(i) * h) + text.charAt(i + m)) % prime;
                if (hashText < 0) {
                    hashText = (hashText + prime);
                }
            }
        }
    }
}
