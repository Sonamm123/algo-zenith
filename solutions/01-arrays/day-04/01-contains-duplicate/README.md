# LeetCode #217 — Contains Duplicate

## Problem

Given an integer array `nums`, determine whether any value appears at least twice in the array.

Return:

* `true` if any duplicate exists.
* `false` if every element is unique.

### Example

```text
Input:  [1,2,3,1]
Output: true
```

```text
Input:  [1,2,3,4]
Output: false
```

---

## Initial Thoughts / First Approach

My first thought was to traverse the array, store the first element, and compare the remaining elements with it to check whether a duplicate exists.

However, this only checks against one element. To correctly detect duplicates, every element needs to be compared with all previously seen elements.

A nested-loop solution could do this, but it would take `O(n²)` time.

---

## Refined Approach

Use a `HashSet` to store the elements that have already been visited.

While traversing the array:

1. Check whether the current element already exists in the set.
2. If it exists, a duplicate has been found, so return `true`.
3. Otherwise, add the current element to the set.
4. If the entire array is traversed without finding a duplicate, return `false`.

The important point is to **check `contains()` before `add()`** because we need to know whether the element was already present.

---

## Why It Works

A `HashSet` stores only unique values.

Therefore, if the current number is already present in the set, it means that the same number appeared earlier in the array.

This allows duplicate detection in average `O(1)` lookup time.

---

## Algorithm

```text
1. Create an empty HashSet.

2. Traverse every element in nums.

3. For each element:
      If the element already exists in the set:
          Return true.

      Otherwise:
          Add the element to the set.

4. Return false.
```

---

## Complexity

* **Time:** `O(n)` average
* **Space:** `O(n)`

---

## Key Learning / Pattern Learned

* HashSet
* Membership checking
* Duplicate detection
* One-pass traversal
* `contains()` before `add()`
* Trading extra space for faster lookup
