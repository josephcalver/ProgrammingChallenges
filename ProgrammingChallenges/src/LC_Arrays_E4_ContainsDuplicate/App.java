package LC_Arrays_E4_ContainsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) return false;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {

        if (nums == null || nums.length == 0) return false;

        Set<Integer> hashTable = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashTable.contains(nums[i])) return true;
            hashTable.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};

        System.out.println(containsDuplicate2(nums));

    }

}
