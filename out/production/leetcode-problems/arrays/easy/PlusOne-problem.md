# 66. Plus One Problem

## Problem Description

You are given a large integer represented as an integer array `digits`, where each `digits[i]` is the ith digit of the integer. The digits are ordered from most significant to least significant (left-to-right). The large integer does not contain any leading 0's.

Your task is to increment the large integer by one and return the resulting array of digits.

---

## Examples

### Example 1:
**Input:**  
`digits = [1,2,3]`  
**Output:**  
`[1,2,4]`  
**Explanation:**  
The array represents the integer `123`.  
Incrementing by one gives `123 + 1 = 124`.  
Thus, the result should be `[1,2,4]`.

### Example 2:
**Input:**  
`digits = [4,3,2,1]`  
**Output:**  
`[4,3,2,2]`  
**Explanation:**  
The array represents the integer `4321`.  
Incrementing by one gives `4321 + 1 = 4322`.  
Thus, the result should be `[4,3,2,2]`.

### Example 3:
**Input:**  
`digits = [9]`  
**Output:**  
`[1,0]`  
**Explanation:**  
The array represents the integer `9`.  
Incrementing by one gives `9 + 1 = 10`.  
Thus, the result should be `[1,0]`.

---

## Constraints

- `1 <= digits.length <= 100`
- `0 <= digits[i] <= 9`
- The input `digits` does not contain any leading 0's.

---

## Notes

- This problem tests your ability to manipulate arrays to represent numbers and handle carry-over scenarios (e.g., when adding one causes digits to "roll over").
- Be mindful of edge cases, such as when all digits are `9` (e.g., `[9, 9, 9]` → `[1, 0, 0, 0]`).
- Ensure your solution works efficiently for large arrays of up to 100 elements.
