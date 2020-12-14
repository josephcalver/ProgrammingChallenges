package LC_E1_RemoveDups;

public class App {

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int i = 0, j = 1, dups = 0;

        while (j < nums.length - dups) {
            while (nums[i] == nums[j]) {
                bubble(nums, j, dups);
                dups++;
            }
            i++;
            j++;
        }
        return nums.length - dups;
    }

    private static void bubble(int[] nums, int index, int dups) {
        for (int i = index; i < nums.length - 1 - dups; i++) {
            swap(nums, i, i + 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int len = removeDuplicates(nums);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicatesLCSolution(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
