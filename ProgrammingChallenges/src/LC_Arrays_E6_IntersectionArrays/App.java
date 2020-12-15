package LC_Arrays_E6_IntersectionArrays;

import java.util.*;

public class App {

    public static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];

        int[] sm;
        int[] lg;

        if (nums1.length == nums2.length) {
            sm = nums1;
            lg = nums2;
        } else {
            sm = nums1.length > nums2.length ? nums2 : nums1;
            lg = nums1.length > nums2.length ? nums1 : nums2;
        }

//        System.out.println(Arrays.toString(sm));
//        System.out.println(Arrays.toString(lg));

        Map<Integer, Integer> smFreqTab = new HashMap<>();

        for (int i : sm) {
            smFreqTab.put(i, smFreqTab.getOrDefault(i, 0) + 1);
        }

        Map<Integer, Integer> lgFreqTab = new HashMap<>();

        for (int i : lg) {
            lgFreqTab.put(i, lgFreqTab.getOrDefault(i, 0) + 1);
        }

//        System.out.println(smFreqTab.toString());
//        System.out.println(lgFreqTab.toString());

        List<Integer> intersection = new ArrayList<>();

        for (int i : smFreqTab.keySet()) {
            if (smFreqTab.get(i) >= 1 && lgFreqTab.getOrDefault(i, 0) >= 1) {
                if (smFreqTab.get(i) == lgFreqTab.get(i)) {
                    addList(intersection, i, smFreqTab.get(i));
                } else {
                    addList(intersection, i, Math.min(smFreqTab.get(i), lgFreqTab.get(i)));
                }
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void addList(List<Integer> list, int num, int freq) {

        for (int i = 0; i < freq; i++) {
            list.add(num);
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};

        int[] result = intersect(nums1, nums2);

        System.out.println(Arrays.toString(result));

    }

}
