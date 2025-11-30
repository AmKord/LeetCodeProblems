package practice.arrays;

import java.util.Arrays;

public class BuyAndSellStock {

  public static void main(String[] args) {
    //int [] prices = {7,1,5,3,6,4};
    int [] prices = {1,2};
    //int [] prices = {2,1};
    //int [] prices = {1};
    //int [] prices = {7,6,4,3,1};
    System.out.println(maxProfit(prices));
  }
  private static int maxProfit(int[] prices) {
    if(prices.length == 1){
      return 0;
    }
    System.out.println(Arrays.toString(prices));
    int [] diffProfitArray = new int[prices.length-1];
    int k =0;
    for(int i =0; i < prices.length-1; i++){
      diffProfitArray[k++] = prices[i+1] - prices[i];
    }

    return maxSumSubArray(diffProfitArray);

    //maxSumSubArray(diffProfitArray);
    //System.out.println("-- "+Arrays.toString(diffProfitArray));
    //return maxSumSubArray(diffProfitArray);
  }

  private static int maxSumSubArray(int[] arr) {
    int currentSum = 0;
    int maxSum = 0;
    for(int i =0; i < arr.length; i++){
      currentSum = Math.max(arr[i], currentSum + arr[i]);
      maxSum = Math.max(currentSum, maxSum);

      }
    return maxSum;
    }
  }

