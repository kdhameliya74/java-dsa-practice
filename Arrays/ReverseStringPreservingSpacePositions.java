package Arrays;

/*
 Problem: Reverse a string preserving space positions
 Difficulty: Easy

 Approach:
 - Convert the string to a character array.
 - Use two pointers (left & right).
 - Skip spaces on both ends.
 - Swap only non-space characters.
 - Spaces remain at their original indices. 


 Time Complexity: O(n)
 Space Complexity: O(n) due to chars array
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
        return newStr;
    }

    public static String optimalSolution(String str) {
        int left = 0;
        int right = str.length() - 1;

        char[] charsArr = str.toCharArray();

        while (left < right) {
            if(charsArr[left] == ' ') {
                left++;
            }
            else if(charsArr[right] == ' ') {
                right--;
            } else {
                char temp = charsArr[left];
                charsArr[left] =  charsArr[right];
                charsArr[right] = temp;
                left++;
                right--;
            }
        }

        return new String(charsArr);
    }

    public static void main(String[] args) {

        String str = "abc de";
        String str1 = "internship at geeks for geeks";

        System.out.println("[1. optimalSolution] -> " + optimalSolution(str));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(str));
        System.out.println("------------------------------------");
        System.out.println("[1. optimalSolution] -> " + optimalSolution(str1));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(str1));

    }
}
