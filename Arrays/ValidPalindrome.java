package Arrays;

/*
 Problem: Valid Palindrome
 Link: https://leetcode.com/problems/valid-palindrome/
 Difficulty: Easy

 Approach:
 - Use two pointers: one starting from the beginning and one from the end of the string.
 - Skip non-alphanumeric characters using Character.isLetterOrDigit().
 - Compare characters in a case-insensitive manner.
 - Move both pointers inward after each valid comparison.
 - If any mismatch occurs, return false; otherwise, return true.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class ValidPalindrome {

    public static boolean nonOptimalSolution(String str) {
        // Space complexity is O(n) because we need cleanedString for storing
        String cleanedString = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int strLen = cleanedString.length();

        for (int i = 0; i < strLen/2; i++) { // we dont need to travel all string
            char firstLetter = cleanedString.charAt(i);
            char lastLetter = cleanedString.charAt(strLen - 1 - i);
            if (firstLetter != lastLetter) {
                return false;
            }
        }
        return true;
    }

    public static boolean optimalSolution(String str) {

        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(str.charAt(left))) left++;
            while(left < right && !Character.isLetterOrDigit(str.charAt(right))) right--;
            
            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";

        System.out.println("[1. optimalSolution] -> " + optimalSolution(s));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(s));
        System.out.println("------------------------------------");
        System.out.println("[1. optimalSolution] -> " + optimalSolution(s1));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(s1));
    }
}
