# Running Sum of 1d Array

**LeetCode:** #1480
**Difficulty:** Easy
**Topic:** Arrays, Prefix Sum / Running Sum
**Language:** Java

---

## 1. Problem

Given an array `nums`, return the running sum of `nums`.

The running sum at index `i` is:

```text
nums[0] + nums[1] + ... + nums[i]
```

### Example

```text
Input:
[1, 2, 3, 4]

Output:
[1, 3, 6, 10]
```

---

## 2. My Initial Thought

Initially, I understood that the first element remains unchanged and that the remaining elements need to be combined with the previous values.

My first thought was:

```text
arr[i] + arr[i + 1]
```

However, this is not the running sum because the problem requires the sum of **all previous elements up to the current index**, not just two adjacent elements.

---

## 3. Refinement of My Approach

After working through an example:

```text
[1, 2, 3, 4]
```

I understood the actual pattern:

```text
1
1 + 2 = 3
3 + 3 = 6
6 + 4 = 10
```

The important observation is that the previous position already contains the running sum.

Therefore:

```text
nums[i] = nums[i] + nums[i - 1]
```

This allows us to solve the problem without creating another array.

---

## 4. Final Approach

Traverse the array from left to right.

For every index starting from `1`:

```text
current element = current element + previous running sum
```

The array itself can be modified because the previous element has already been converted into its running sum.

---

## 5. Algorithm

1. Start traversal from index `1`.
2. Add `nums[i - 1]` to `nums[i]`.
3. Store the result in `nums[i]`.
4. Continue until the end of the array.
5. Return `nums`.

### Pseudocode

```text
for i = 1 to n - 1:
    nums[i] = nums[i] + nums[i - 1]

return nums
```

---

## 6. Dry Run

Input:

```text
nums = [1, 2, 3, 4]
```

| Index | Calculation  | Array           |
| ----: | ------------ | --------------- |
|     0 | Initial      | `[1, 2, 3, 4]`  |
|     1 | `2 + 1 = 3`  | `[1, 3, 3, 4]`  |
|     2 | `3 + 3 = 6`  | `[1, 3, 6, 4]`  |
|     3 | `4 + 6 = 10` | `[1, 3, 6, 10]` |

Final output:

```text
[1, 3, 6, 10]
```

---

## 7. Complexity

* **Time Complexity:** `O(n)`
* **Auxiliary Space Complexity:** `O(1)`

The input array is modified in-place, so no additional array is required.

---

## 8. Key Takeaway

The main learning from this problem is:

> **The result calculated at the previous position can be reused to calculate the current position.**

This introduces the idea of a **running sum / prefix sum**, which is an important array pattern used in many DSA problems.

---

## 9. Java Implementation

See [`Solution.java`](./Solution.java).
