package org.example.ProblemC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program is designed to input only 1 image
 * Scanner needs to be adjusted to be able to input up to 10 images
 * Also using BufferedReader instead of scanner is preferable to have a better performance
 */

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> scanLines = new ArrayList<>();
        int counter = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < counter; i++) {
            scanLines.add(scanner.nextLine());
        }
        int number;
        boolean isHashTag;
        String pixel;
        for (String line : scanLines) {
            char[] a = line.toCharArray();
            isHashTag = (a[0] == '#');
            for (int i = 1; i < a.length; i++) {
                number = Character.getNumericValue(a[i]);
                while (number != 0) {
                    number--;
                    if (i % 2 != 0) {
                        pixel = isHashTag ? "#" : ".";
                        System.out.print(pixel);
                    } else {
                        pixel = isHashTag ? "." : "#";
                        System.out.print(pixel);
                    }
                }
            }
            System.out.println();
        }
    }
}

