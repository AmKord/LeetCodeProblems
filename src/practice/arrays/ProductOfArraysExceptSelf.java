package practice.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductOfArraysExceptSelf {

  public static void main(String[] args) {
    //int [] arr = {1,2,3,4};
    int[] arr = {-1, 1, 0, -3, 3};
    calculateProduct(arr);
  }

  private static void calculateProduct(int[] nums) {
    int[] prefix = calculatePrefix(nums);
    int[] suffix = calculateSuffix(nums);
    System.out.println(Arrays.toString(multiplyPrefixAndSuffix(prefix, suffix)));
  }

  private static int[] multiplyPrefixAndSuffix(int[] prefix, int[] suffix) {
    int[] product = new int[prefix.length];
    for (int i = 0; i < prefix.length; i++) {
      product[i] = prefix[i] * suffix[i];
    }
    return product;
  }


  private static int[] calculatePrefix(int[] nums) {
    int [] prefixMultiplication = new int[nums.length];
    for(int i =0; i < nums.length; i++){
      if(i == 0){
        prefixMultiplication[i] = 1;
      } else{
        prefixMultiplication[i] = prefixMultiplication[i-1] * nums [i-1];
      }
    }
    System.out.println(Arrays.toString(prefixMultiplication));
    return prefixMultiplication;
  }

  private static int[] calculateSuffix(int[] nums) {
    int [] suffixMultiplication = new int[nums.length];
    for(int i =nums.length-1; i >= 0; i--){
      if(i == nums.length-1){
        suffixMultiplication[i] = 1;
      } else{
        suffixMultiplication[i] = suffixMultiplication[i+1] * nums [i+1];
      }
    }
    System.out.println(Arrays.toString(suffixMultiplication));
    return suffixMultiplication;
  }

}
