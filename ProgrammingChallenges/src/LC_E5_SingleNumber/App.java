package LC_E5_SingleNumber;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int singleNumber = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //System.out.println(entry);
            if (entry.getValue() == 1) {
                singleNumber = entry.getKey();
            }
        }
        return singleNumber;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 3, 3, 4 };

        System.out.println(singleNumber(nums));
    }

}
