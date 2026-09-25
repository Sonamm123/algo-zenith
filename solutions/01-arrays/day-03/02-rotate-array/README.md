# LeetCode 189 — Rotate Array

**Difficulty:** Medium
**Topic:** Arrays, In-place Manipulation, Reversal

---

## Problem

Given an integer array `nums`, rotate the array to the right by `k` steps.

A rotation by one step moves the last element to the first position.

---

## Example

**Input:**

```text
nums = [1, 2, 3, 4, 5, 6, 7]
k = 3
```

**Output:**

```text
[5, 6, 7, 1, 2, 3, 4]
```

---

## Initial Thoughts / First Approach

My first thought was to shift the elements to the right.

For example, for:

```text
[1, 2, 3, 4, 5]
```

and `k = 2`:

```text
[1, 2, 3, 4, 5]
          ↓
[5, 1, 2, 3, 4]
          ↓
[4, 5, 1, 2, 3]
```

This approach works, but performing the shifting repeatedly can take **O(n × k)** time.

For large values of `n` and `k`, this is inefficient.

---

## Refined Approach

Use the **three-reversal technique**.

First reduce unnecessary rotations:

```text
k = k % n
```

Then perform three reversals:

### Step 1 — Reverse the entire array

```text
[1, 2, 3, 4, 5, 6, 7]

        ↓

[7, 6, 5, 4, 3, 2, 1]
```

### Step 2 — Reverse the first `k` elements

For `k = 3`:

```text
[7, 6, 5, 4, 3, 2, 1]

        ↓

[5, 6, 7, 4, 3, 2, 1]
```

### Step 3 — Reverse the remaining elements

```text
[5, 6, 7, 4, 3, 2, 1]

        ↓

[5, 6, 7, 1, 2, 3, 4]
```

The required rotated array is obtained.

---

## Why Does This Work?

Suppose the original array is divided into:

```text
A B
```

where `B` contains the last `k` elements.

The required result is:

```text
B A
```

Reversing the entire array gives:

```text
reverse(B) reverse(A)
```

Then reversing each part individually gives:

```text
B A
```

Therefore, three reversals produce the required rotation.

---

## Algorithm

```text
k = k % n

Reverse the entire array

Reverse the first k elements

Reverse the remaining n-k elements
```

The reversal operation uses two pointers:

```text
start →              ← end

Swap nums[start] and nums[end]

Move start forward
Move end backward

Continue until start >= end
```

---

## Code

The implementation uses a helper `reverse()` method to perform each reversal in-place.

---

## Complexity

* **Time:** O(n)
* **Extra Space:** O(1)

Each element is involved in a constant number of swap operations.

---

## Key Learning

The main lesson from this problem is that a seemingly expensive repeated operation can often be replaced by a mathematical or structural transformation.

Here, repeated shifting was replaced by **three reversals**, giving:

```text
O(n × k)  →  O(n)
```

while still using **O(1) extra space**.

This is an important pattern for solving **in-place array manipulation** problems.
