# LeetCode #169 — Majority Element

## Problem

Given an integer array `nums` of size `n`, return the element that appears more than `n / 2` times.

The majority element is guaranteed to exist.

### Example

```text
Input:  [2,2,1,1,1,2,2]
Output: 2
```

Here:

```text
2 appears 4 times
1 appears 3 times
```

Since:

```text
4 > 7 / 2
```

`2` is the majority element.

---

## Initial Thoughts / First Approach

A straightforward approach would be to count how many times each element occurs.

A `HashMap` could store:

```text
number → frequency
```

Then, while traversing the array, we could find the element whose frequency becomes greater than `n / 2`.

This approach would work in `O(n)` time, but it requires `O(n)` extra space.

Since the problem guarantees that a majority element exists, we can optimize the space further.

---

## Refined Approach

Use the **Boyer-Moore Voting Algorithm**.

Maintain two variables:

* `candidate` — the current possible majority element.
* `count` — the current vote count for that candidate.

For every number:

1. If `count == 0`, choose the current number as the new candidate.
2. If the current number equals the candidate, increase `count`.
3. Otherwise, decrease `count`.

The idea is that a majority element appears more than all other elements combined.

Therefore, every occurrence of a different element can be considered to cancel one occurrence of the majority candidate.

Because the majority element has more occurrences than all other elements combined, it cannot be completely cancelled.

---

## Why It Works

Consider:

```text
[2,2,1,1,1,2,2]
```

Think of:

```text
same element      → +1 vote
different element → -1 vote
```

The majority element has more votes than all other elements combined.

Therefore, after cancelling pairs of different elements, the majority element remains as the final candidate.

This allows us to find the majority element without storing frequencies.

---

## Algorithm

```text
1. Set candidate = 0.
2. Set count = 0.

3. Traverse every element in nums.

4. If count == 0:
      candidate = current element

5. If current element == candidate:
      count++
   Otherwise:
      count--

6. Return candidate.
```

---

## Complexity

* **Time:** `O(n)`
* **Space:** `O(1)`

---

## Key Learning / Pattern Learned

* Boyer-Moore Voting Algorithm
* Candidate and counter technique
* Majority element
* Cancellation principle
* Frequency optimization
* Constant-space algorithm
