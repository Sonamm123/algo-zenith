# Concatenation of Array

* **LeetCode:** #1929
* **Difficulty:** Easy
* **Topic:** Arrays, Index Mapping
* **Language:** Java

## Problem Statement

Given an integer array `nums` of length `n`, create an array `ans` of length `2n` such that:

```text
ans = nums + nums
```

In other words:

```text
ans[i] = nums[i]
ans[i + n] = nums[i]
```

### Example

```text
Input:
nums = [1, 2, 1]

Output:
[1, 2, 1, 1, 2, 1]
```

---

## My Initial Thought

My first thought was to traverse the array and create a new array with double the size.

I initially thought about manually counting the elements and copying the original array into the first and second halves.

The important observation was that the length of the original array can be obtained directly using:

```java
nums.length
```

So there is no need to manually count the elements.

---

## Refinement

If:

```text
n = nums.length
```

then the answer array has:

```text
2 * n
```

elements.

For every index `i`:

* If `i < n`, copy `nums[i]`
* Otherwise, use `nums[i - n]`

This gives:

```text
nums = [1, 2, 1]

i = 0 → ans[0] = nums[0]
i = 1 → ans[1] = nums[1]
i = 2 → ans[2] = nums[2]

i = 3 → ans[3] = nums[3 - 3] = nums[0]
i = 4 → ans[4] = nums[4 - 3] = nums[1]
i = 5 → ans[5] = nums[5 - 3] = nums[2]
```

---

## Approach

1. Find the length of the input array.
2. Create an answer array of size `2 * n`.
3. Traverse the answer array.
4. Copy the corresponding element from `nums`.
5. Return the answer array.

---

## Algorithm

```text
n = nums.length
create ans[2 * n]

for i = 0 to 2*n - 1:
    if i < n:
        ans[i] = nums[i]
    else:
        ans[i] = nums[i - n]

return ans
```

---

## Dry Run

For:

```text
nums = [1, 2, 1]
n = 3
```

| `i` | Condition | Assignment             |
| --: | --------- | ---------------------- |
|   0 | `i < n`   | `ans[0] = nums[0] = 1` |
|   1 | `i < n`   | `ans[1] = nums[1] = 2` |
|   2 | `i < n`   | `ans[2] = nums[2] = 1` |
|   3 | `i >= n`  | `ans[3] = nums[0] = 1` |
|   4 | `i >= n`  | `ans[4] = nums[1] = 2` |
|   5 | `i >= n`  | `ans[5] = nums[2] = 1` |

Final:

```text
[1, 2, 1, 1, 2, 1]
```

---

## Complexity

* **Time:** `O(n)`
* **Space:** `O(n)` for the required output array

---

## Key Takeaway

The main pattern learned from this problem is **index mapping**.

Instead of using nested loops, we can determine exactly which input index corresponds to each output index.

---

## Java Implementation

See [`Solution.java`](Solution.java).
