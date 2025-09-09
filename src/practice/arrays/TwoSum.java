package practice.arrays;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * Input: nums = = [2,5,5,11], target = 10;
 * Output: [1,2]
 *
 *
 *
 *
 * Constraints:
 *
 *     2 <= nums.length <= 104
 *     -109 <= nums[i] <= 109
 *     -109 <= target <= 109
 *     Only one valid answer exists.
 */
public class TwoSum {
    public static void main(String[] args) {
        //int [] nums = {2,7,11,15};
        //int [] nums = {3,2,4};
        int [] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        //desired number is 9 - num
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }
        System.out.println(numIndexMap);
        int[] result = new int[2];
        int k = 0;
        for (int i = 0; i < nums.length && k<2; i++) {

                int value = target - nums[i];
                for (int j = 0; j < nums.length; j++) {
                    if(nums[j] == value && i!=j){
                        System.out.println("NUMBER:: "+nums[i] +" INDEX:: "+ j);
                        result[k++] = j;
                    }


            }
        }
        System.out.println(Arrays.toString(result));
    }

    //Optimal Solution
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
