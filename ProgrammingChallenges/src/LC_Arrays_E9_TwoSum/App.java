package LC_Arrays_E9_TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new int[0];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
         }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {

        //if (nums == null || nums.length == 0) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        int complement = 0;

        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution for given input");
    }


    public static void main(String[] args) {

        int[] nums = {3, 2, 4};

        int[] result = twoSum2(nums, 6);

        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSumLCSolution(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

}
