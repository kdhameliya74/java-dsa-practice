package Arrays;

// In Progress

/*
 Problem: Reverse a string preserving space positions
 Difficulty: Easy

 Approach:
 

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class ReverseStringPreservingSpacePositions {
    public static String nonOptimalSolution(String str) {
        int right = str.length() - 1;
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr = newStr + ' ';
                continue;
            } 
            if (str.charAt(right) == ' ') {
                right--;
            } 
            newStr += str.charAt(right);
            if(right != 0) {
                right--;
            }
        }

        System.out.println(newStr);
        return "";
    }

    public static boolean optimalSolution() {
        return true;
    }

    public static void main(String[] args) {

        String str = "abc de";

        // System.out.println("[1. optimalSolution] -> " + optimalSolution(s));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(str));
        // System.out.println("------------------------------------");
        // System.out.println("[1. optimalSolution] -> " + optimalSolution(s1));
        // System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(s1));

    }
}
