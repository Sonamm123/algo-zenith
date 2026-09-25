# LeetCode #53 — Maximum Subarray

## Problem

Given an integer array `nums`, find the contiguous subarray with the largest sum and return its sum.

### Example

```text
Input:  [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
```

The maximum-sum subarray is:

```text
[4,-1,2,1]
```

whose sum is:

```text
4 + (-1) + 2 + 1 = 6
```

---

## Initial Thoughts / First Approach

My first thought was to traverse the array and keep adding the next elements repeatedly to calculate different possible subarray sums.

The problem with this approach is that checking every possible subarray would require many repeated calculations and could lead to `O(n²)` time.

I needed a way to make the decision at each element without recalculating previous subarrays.

---

## Refined Approach

Use **Kadane's Algorithm**.

At every element, maintain two values:

* `currentSum` — the maximum sum of a subarray ending at the current element.
* `maxSum` — the maximum subarray sum found so far.

For every element, there are two choices:

1. Start a new subarray from the current element.
2. Extend the previous subarray by adding the current element.

Therefore:

```text
currentSum = max(current element,
                 currentSum + current element)
```

Then update:

```text
maxSum = max(maxSum, currentSum)
```

---

## Why It Works

Suppose the previous `currentSum` is negative.

Adding a negative value to the current element would make the result smaller than simply starting a new subarray from the current element.

Therefore, we discard the previous subarray when it hurts the sum.

This gives the key idea behind Kadane's Algorithm:

> If the previous sum makes the current result worse, start fresh.

The algorithm still works when all elements are negative because it starts with `nums[0]` instead of `0`.

---

## Algorithm

```text
1. Set currentSum = nums[0].
2. Set maxSum = nums[0].

3. Traverse the array from index 1.

4. For every element:
      currentSum = max(current element,
                       currentSum + current element)

      maxSum = max(maxSum, currentSum)

5. Return maxSum.
```

---

## Complexity

* **Time:** `O(n)`
* **Space:** `O(1)`

---

## Key Learning / Pattern Learned

* Kadane's Algorithm
* Maximum subarray
* Running sum
* Decision to extend or restart
* One-pass optimization
* Constant-space optimization
