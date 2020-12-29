package _8_4_PowerSet;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    /*
        Write a method to return all subsets of a set.
        There is also a binary/bitwise solution to come back to.
     */

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {

        ArrayList<ArrayList<Integer>> allSubsets;

        // base case and build -- empty ArrayList of empty ArrayLists
        if (set.size() == index) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                newSubsets.add(newSubset);
            }
            allSubsets.addAll(newSubsets);
        }
        return allSubsets;
    }


    public static void main(String[] args) {

        ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        ArrayList<ArrayList<Integer>> subsets = getSubsets(set, 0);

        for (ArrayList<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }

}
