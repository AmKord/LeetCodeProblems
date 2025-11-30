package practice.arrays;

public class BuySellStock_Alternate {

  public static void main(String[] args) {
    int [] prices = {7,1,5,3,6,4,2,9};
    //int [] prices = {1,2};
    //int [] prices = {2,1};
    //int [] prices = {1};
    //int [] prices = {7,6,4,3,1};
    System.out.println(maxProfit(prices));
  }

  private static int maxProfit(int[] prices) {
    int profit = 0;
    int buyPrice = prices[0];
    for(int i = 1 ; i < prices.length; i++){
      if(prices[i] < buyPrice){
        buyPrice = prices[i];
      } else if ((prices[i] - buyPrice) > profit){
        profit = prices[i] - buyPrice;
      }
    }
    return profit;
  }

}
