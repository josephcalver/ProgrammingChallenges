package _8_3_MagicIndex;

public class App {

    public static int magicIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return magicIndex(nums, 0, nums.length - 1);
    }

    private static int magicIndex(int[] nums, int start, int end) {

        if (end < start) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == mid) {
            return mid;
        }  else if (nums[mid] > mid) {
            return magicIndex(nums, start, mid - 1);
        } else {
            return magicIndex(nums, mid + 1, end);
        }
    }

    // if array integers are not distinct

    public static int magicIndexNonDistinct(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return magicIndexNonDistinct(nums, 0, nums.length - 1);
    }

    private static int magicIndexNonDistinct(int[] nums, int start, int end) {

        if (end < start) {
            return -1;
        }

        int midIndex  = (start + end) / 2;
        int midValue = nums[midIndex];

        if (midIndex == midValue) {
            return midIndex;
        }

        // search left
        int left = magicIndexNonDistinct(nums, start, Math.min(midIndex - 1, midValue));
        if (left >= 0) {
            return left;
        }

        // search right
        int right = magicIndexNonDistinct(nums, Math.max(midIndex + 1, midValue), end);

        return right;
    }


    public static void main(String[] args) {

        int[] nums = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };

        int result = magicIndex(nums);

        System.out.println(result);

        int[] numsNonDistinct = { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };

        int result2 = magicIndexNonDistinct(numsNonDistinct);

        System.out.println(result2);

    }

}
