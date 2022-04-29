package org.example.problemA;

import java.util.Scanner;

/**
 * Date : 2022/04/27
 * Author :  Negar Madadi
 * Problem A
 */

public class ProblemA {
    public static void main(String[] args) {
        System.out.println("Type two numbers that shows the moose tines in each side");
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        countThePointsOfMoose(l, r);
    }

    /**
     * Method to calculate the amounts of the moose points which shows the moose age
     *
     * @param l left antler
     * @param r right antler
     */
    public static void countThePointsOfMoose(int l, int r) {

        boolean tinesAmountAreGreaterThanZero = ((0 <= l && l <= 20) && (0 <= r && r <= 20));
        int totalAmountOfTines = Math.max(l, r) * 2;
        if (tinesAmountAreGreaterThanZero) {
            if (r == l) {
                if (l != 0) {
                    System.out.println("Even " + totalAmountOfTines);
                } else {
                    System.out.println("Not a moose");
                }
            } else {
                System.out.println("Odd " + totalAmountOfTines);
            }
        }
    }
}