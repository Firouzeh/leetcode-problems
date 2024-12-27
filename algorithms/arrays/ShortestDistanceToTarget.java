package arrays;

class ShortestDistanceToTarget {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                // Calculate both forward and backward distances
                int forwardDistance = Math.abs(i - startIndex);
                int backwardDistance = n - forwardDistance;
                int currentDistance = Math.min(forwardDistance, backwardDistance);

                // Update the minimum distance
                minDistance = Math.min(minDistance, currentDistance);
            }
        }

        // If no target was found, return -1
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {
        ShortestDistanceToTarget solution = new ShortestDistanceToTarget();

        // Test cases
        String[] words1 = {"hello", "i", "am", "leetcode", "hello"};
        System.out.println(solution.closetTarget(words1, "hello", 1)); // Output: 1

        String[] words2 = {"a", "b", "leetcode"};
        System.out.println(solution.closetTarget(words2, "leetcode", 0)); // Output: 1

        String[] words3 = {"i", "eat", "leetcode"};
        System.out.println(solution.closetTarget(words3, "ate", 0)); // Output: -1
    }
}
