package org.example.problems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CountPAirWhoseSumIsLessThanTarget {
    /*
    * Count pairs whose sum is les than target.
    * My real value to search should be any value based on current index - target.
    * Need to keep track of the valid combinations to avoid repeating values.
    * Need to ensure sume
    *
     */
    public static void main(String[] args) {
        System.out.println(countPairs(List.of(-1, 1, 2, 3, 1), -2));
    }

    public static int countPairs(List<Integer> nums, int target) {
        Map<Integer, Integer> validCombinations = new HashMap<>();
        if(!validCombinations.containsKey() && validCombinations.get()  != value)
        return -1 - target;
    }
}