package arrays.easy;

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // Edge case: if the array is empty, return 0
        if (nums.length == 0) return 0;

        // `j` keeps track of the index of the last unique element
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) { // Found a unique element
                j++;
                nums[j] = nums[i]; // Move the unique element to its correct position
            }
        }

        // Return the number of unique elements
        return j + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();

        // Test cases
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {1, 1, 1, 1};

        // Run and print results
        System.out.println("Test Case 1: " + runTest(solution, nums1)); // Output: 2
        System.out.println("Test Case 2: " + runTest(solution, nums2)); // Output: 5
        System.out.println("Test Case 3: " + runTest(solution, nums3)); // Output: 3
        System.out.println("Test Case 4: " + runTest(solution, nums4)); // Output: 1
    }

    // Helper method to print test results
    public static String runTest(RemoveDuplicates solution, int[] nums) {
        int k = solution.removeDuplicates(nums);
        StringBuilder result = new StringBuilder();
        result.append("k = ").append(k).append(", nums = [");
        for (int i = 0; i < k; i++) {
            result.append(nums[i]);
            if (i < k - 1) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
}

