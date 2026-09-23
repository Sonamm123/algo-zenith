# Shuffle the Array

* **LeetCode:** #1470
* **Difficulty:** Easy
* **Topic:** Arrays, Index Mapping
* **Language:** Java

## Problem Statement

Given an array:

```text
nums = [x1, x2, ..., xn, y1, y2, ..., yn]
```

return:

```text
[x1, y1, x2, y2, ..., xn, yn]
```

### Example

```text
Input:
nums = [2, 5, 1, 3, 4, 7]
n = 3

Output:
[2, 3, 5, 4, 1, 7]
```

The first half contains the `x` values:

```text
[2, 5, 1]
```

The second half contains the `y` values:

```text
[3, 4, 7]
```

---

## My Initial Thought

My first thought was to divide the array into two halves:

```text
x = [2, 5, 1]
y = [3, 4, 7]
```

Then take one element from each half alternately.

I initially considered using nested loops, but that is unnecessary.

---

## Refinement

For every index `i`:

```text
x[i] = nums[i]
y[i] = nums[i + n]
```

The result needs to place them alternately.

Therefore:

```text
ans[2*i]     = nums[i]
ans[2*i + 1] = nums[i + n]
```

This allows the entire problem to be solved using a single loop.

---

## Approach

1. Create an answer array of size `2 * n`.
2. Traverse the first half using index `i`.
3. Place `nums[i]` at an even index.
4. Place `nums[i + n]` at the following odd index.
5. Return the result.

---

## Algorithm

```text
create ans[2 * n]

for i = 0 to n - 1:
    ans[2*i] = nums[i]
    ans[2*i + 1] = nums[i + n]

return ans
```

---

## Dry Run

Input:

```text
nums = [2, 5, 1, 3, 4, 7]
n = 3
```

| `i` | `nums[i]` | `nums[i+n]` | Result positions       |
| --: | --------: | ----------: | ---------------------- |
|   0 |         2 |           3 | `ans[0]=2`, `ans[1]=3` |
|   1 |         5 |           4 | `ans[2]=5`, `ans[3]=4` |
|   2 |         1 |           7 | `ans[4]=1`, `ans[5]=7` |

Final:

```text
[2, 3, 5, 4, 1, 7]
```

---

## Complexity

* **Time:** `O(n)`
* **Space:** `O(n)` for the output array

---

## Key Takeaway

This problem reinforces **index mapping**.

The important relationship is:

```text
Input:
x values → nums[i]
y values → nums[i+n]

Output:
x → ans[2*i]
y → ans[2*i+1]
```

No nested loop is required.

---

## Java Implementation

See [`Solution.java`](Solution.java).
