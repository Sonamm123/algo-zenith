# Product of Array Except Self

* **LeetCode:** #238
* **Difficulty:** Medium
* **Topic:** Arrays, Prefix Product, Suffix Product
* **Language:** Java

## Problem Statement

Given an integer array `nums`, return an array `answer` such that:

```text
answer[i]
```

is equal to the product of every element in `nums` except `nums[i]`.

The solution must run in `O(n)` time and should not use division.

### Example

```text
Input:
nums = [1, 2, 3, 4]

Output:
[24, 12, 8, 6]
```

Explanation:

```text
index 0 → 2 × 3 × 4 = 24
index 1 → 1 × 3 × 4 = 12
index 2 → 1 × 2 × 4 = 8
index 3 → 1 × 2 × 3 = 6
```

---

## My Initial Thought

My first thought was:

For every index:

```text
answer[i] =
    product of all elements on the left
    ×
    product of all elements on the right
```

For example:

```text
nums = [2, 3, 4, 5]
```

At index `2`:

```text
Left  = 2 × 3 = 6
Right = 5

answer[2] = 6 × 5 = 30
```

The idea was correct, but calculating the left and right products separately for every index would result in unnecessary repeated work.

---

## Refinement

Instead of recalculating the products for every index, we can maintain running products.

### Left Product

Traverse from left to right.

For each index, store the product of all elements before it.

For:

```text
nums = [2, 3, 4, 5]
```

the left-product values are:

```text
[1, 2, 6, 24]
```

The value `1` is used because there are no elements to the left of index `0`.

### Right Product

Then traverse from right to left.

Maintain the product of all elements after the current index.

For the same array, the running right products are:

```text
1 → 5 → 20 → 60
```

These right products are multiplied into the values already stored in `answer`.

---

## Optimized Approach

We can use the output array itself to store the left products.

### First Pass — Left to Right

Before processing `nums[i]`, `left` contains the product of all elements before `i`.

```text
answer[i] = left
left = left × nums[i]
```

### Second Pass — Right to Left

Before processing `nums[i]`, `right` contains the product of all elements after `i`.

```text
answer[i] = answer[i] × right
right = right × nums[i]
```

This avoids creating separate prefix and suffix arrays.

---

## Algorithm

```text
create answer[n]

left = 1

for i = 0 to n-1:
    answer[i] = left
    left = left × nums[i]

right = 1

for i = n-1 down to 0:
    answer[i] = answer[i] × right
    right = right × nums[i]

return answer
```

---

## Dry Run

Input:

```text
nums = [2, 3, 4, 5]
```

### First Pass

Start:

```text
left = 1
```

| `i` | `answer[i]` |  Update `left` |
| --: | ----------: | -------------: |
|   0 |           1 |    `1 × 2 = 2` |
|   1 |           2 |    `2 × 3 = 6` |
|   2 |           6 |   `6 × 4 = 24` |
|   3 |          24 | `24 × 5 = 120` |

Now:

```text
answer = [1, 2, 6, 24]
```

### Second Pass

Start:

```text
right = 1
```

| `i` | Calculation | `answer[i]` |    New `right` |
| --: | ----------- | ----------: | -------------: |
|   3 | `24 × 1`    |          24 |    `1 × 5 = 5` |
|   2 | `6 × 5`     |          30 |   `5 × 4 = 20` |
|   1 | `2 × 20`    |          40 |  `20 × 3 = 60` |
|   0 | `1 × 60`    |          60 | `60 × 2 = 120` |

Final:

```text
[60, 40, 30, 24]
```

---

## Complexity

* **Time:** `O(n)`
* **Auxiliary Space:** `O(1)` excluding the required output array
* **Output Space:** `O(n)`

---

## Key Takeaway

This problem teaches the **prefix/suffix pattern**.

Instead of repeatedly calculating products, maintain:

```text
Left product  → left to right
Right product → right to left
```

The output array is reused to store the left products before multiplying the right products into it.

This technique is useful in many array problems where each position depends on elements before and after it.

---

## Java Implementation

See [`Solution.java`](Solution.java).

