package Arrays;

/*
 Problem: Best Time to Buy and Sell Stock
 Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 Difficulty: Easy

 Approach:
 - Use minPrice and maxPrice for storing
 - For each element, check if (price < minPrince) update minPrice
 - Else count profit, if newProfit is high update with maxProfit

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

/* 

Understanding:

days-          1,2,3,4,5,6
stocks price - 7,1,5,3,6,4

1st day - 7
2nd day - 2
... so on

Prices:   7   1   5   3   6   4   8   9
Days:     0   1   2   3   4   5   6   7

MinPrice: 7 → 1 → 1 → 1 → 1 → 1 → 1 → 1
Profit:   0   0   4   2   5   3   7   8
MaxProfit updated gradually → 8

*/

public class BestTimeToBuyAndSellStock {

    public static int nonOptimalSolution(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (diff > maxProfit) {
                    maxProfit = diff;
                }
            }
        }
        return maxProfit;
    }

    public static int optimalSolution(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices) {
            if(price < minPrice) {
                minPrice = price;
            } else {
                int newProfit = price - minPrice;
                if(newProfit > maxProfit) {
                    maxProfit = newProfit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4, 8, 9 };
        System.out.println("[1. nonOptimalSolution] Max profit is " + nonOptimalSolution(prices));
        System.out.println("[2. optimalSolution] Max profit is " + optimalSolution(prices));
    }
}