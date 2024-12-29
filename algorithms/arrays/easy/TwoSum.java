package arrays.easy;

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the indices of numbers
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Find the complement
            if (map.containsKey(complement)) {
                // If complement exists, return the indices
                return new int[]{map.get(complement), i};
            }
            // Otherwise, store the current number and its index in the map
            map.put(nums[i], i);
        }

        // This will never be reached because the problem guarantees one solution
        throw new IllegalArgumentException("No solution exists");
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 26;

        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}

