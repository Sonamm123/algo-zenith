# LeetCode 283 — Move Zeroes

**Difficulty:** Easy
**Topic:** Arrays, Two Pointers, In-place Manipulation

---

## Problem

Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.

The operation must be performed **in-place**.

---

## Example

**Input:**

```text
[0, 1, 0, 3, 12]
```

**Output:**

```text
[1, 3, 12, 0, 0]
```

---

## Approach

Use an `insertPos` pointer to track the position where the next non-zero element should be placed.

### Step 1 — Move non-zero elements

Traverse the array from left to right.

Whenever a non-zero element is found:

```text
nums[insertPos] = nums[i]
```

Then increment `insertPos`.

This moves all non-zero elements toward the beginning while preserving their order.

### Step 2 — Fill remaining positions with zero

After all non-zero elements have been placed, every position from `insertPos` to the end must contain `0`.

---

## Algorithm

```text
insertPos = 0

For every element in nums:
    If nums[i] is not zero:
        Place nums[i] at nums[insertPos]
        Increment insertPos

While insertPos < n:
    Set nums[insertPos] = 0
    Increment insertPos
```

---

## Complexity

* **Time:** O(n)
* **Extra Space:** O(1)

---

## Key Learning

The important idea is to separate the problem into two phases:

1. Place all useful elements first.
2. Fill the remaining positions with zeros.

This is an example of **in-place array manipulation**.
