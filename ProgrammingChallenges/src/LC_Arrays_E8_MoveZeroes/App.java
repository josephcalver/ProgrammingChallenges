package LC_Arrays_E8_MoveZeroes;

import java.util.Arrays;

public class App {

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int slow = 0;
        int temp = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {3, 0, 4, 0, 5, 0, 1, 0, 0, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

}
