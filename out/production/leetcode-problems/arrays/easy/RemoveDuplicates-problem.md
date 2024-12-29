# 26. Remove Duplicates from Sorted Array

## Problem Description

Given an integer array `nums` sorted in non-decreasing order, remove the duplicates **in-place** such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in `nums`.

### Requirements:
- Consider the number of unique elements of `nums` to be `k`.
- Your solution must modify the array `nums` such that:
    1. The first `k` elements contain the unique elements in the order they were present in `nums` initially.
    2. The remaining elements of `nums` are not important and can be ignored.
- Return `k`.

### Custom Judge:
The judge will test your solution with the following code:
```java
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
