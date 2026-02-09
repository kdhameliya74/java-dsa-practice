package Arrays;

import java.util.Arrays;

/*
 Problem: Corporate Flight Bookings
 Link: https://leetcode.com/problems/corporate-flight-bookings/
 Difficulty: Medium

 Approach:

 Time Complexity: O(n + m)
 Space Complexity: O(n)
*/

public class CorporateFlightBookings {
    public static String nonOptimalSolution(int[][] bookings, int flight) {
        //Time complexity is  O(m *n)
        int[] answers = new int[flight];

        for (int[] booking : bookings) { // m
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            for (int i = first; i <= last; i++) { // n
                answers[i - 1] = answers[i - 1] + seats;
            }
        }

        return Arrays.toString(answers);
    }

    public static String optimalSolution(int[][] bookings, int flight) {
        int[] answers = new int[flight];
        for (int[] booking : bookings) { // time complexity O(n)
            int first = booking[0] - 1; // start index at 0
            int last = booking[1] - 1;
            int seats = booking[2];

            answers[first] += seats;
            if(last + 1 < flight) { // stop adding seats, this logic creates difference array
                answers[last + 1] -= seats;
            }  
        }

        for(int i = 1; i < flight; i++) { // time complexity O(m)
            answers[i] += answers[i-1];
        }

        return Arrays.toString(answers);
    }

    public static void main(String[] args) {
        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int n = 5;
        System.out.println("[1. optimalSolution] -> " + optimalSolution(bookings, n));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(bookings, n));

    }
}
