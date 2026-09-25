# LeetCode 11 — Container With Most Water

**Difficulty:** Medium
**Topic:** Arrays, Two Pointers, Greedy

---

## Problem

Given an integer array `height`, where each element represents the height of a vertical line, choose two lines that together with the x-axis form a container that holds the maximum amount of water.

Return the maximum amount of water the container can store.

---

## Example

**Input:**

```text id="2q9r7s"
height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
```

**Output:**

```text id="3q6y7p"
49
```

---

## Initial Thoughts / Understanding the Problem

At first, the problem was difficult to understand because the array represents vertical walls rather than simply being a normal array problem.

The key observation is:

> Choose two vertical walls and calculate how much water can fit between them.

For two positions `left` and `right`:

```text id="6w4c2a"
Width = right - left
```

The water cannot rise above the shorter wall.

Therefore:

```text id="k4e7x1"
Water Height = min(height[left], height[right])
```

So the area is:

```text id="y2q8cd"
Area = Width × Water Height
```

or:

```text id="r0b4dz"
Area = (right - left) × min(height[left], height[right])
```

---

## First Approach

A straightforward approach would be to check every possible pair of walls.

For every pair:

```text id="h4p7sx"
Calculate width
Calculate the shorter height
Calculate area
Keep the maximum area
```

However, there can be O(n²) pairs, making this approach too slow for large arrays.

So we need a more efficient approach.

---

## Refined Approach — Two Pointers

Use two pointers:

```text id="9c6r2w"
left = 0
right = n - 1
```

This starts with the widest possible container.

At every step:

1. Calculate the width.
2. Find the shorter wall.
3. Calculate the current area.
4. Update the maximum area.
5. Move the pointer corresponding to the shorter wall.

---

## Why Move the Shorter Wall?

This is the most important idea in the problem.

Suppose:

```text id="3b8m1k"
height[left] < height[right]
```

The left wall is the shorter wall.

The current area is limited by:

```text id="y4x9qn"
height[left]
```

If we move the **right pointer** instead:

* Width decreases.
* The limiting left height remains the same.
* Therefore, we cannot get a better area by keeping the same shorter wall.

So we move:

```text id="v8z2ka"
left++
```

Similarly, if the right wall is shorter:

```text id="e3j6wp"
right--
```

This gives us a way to eliminate many unnecessary pairs.

---

## Algorithm

```text id="qwrtgd"
left = 0
right = n - 1
maxArea = 0

while left < right:

    width = right - left

    height = minimum(height[left], height[right])

    area = width × height

    maxArea = maximum(maxArea, area)

    if height[left] < height[right]:
        left++
    else:
        right--

return maxArea
```

---

## Example Walkthrough

Consider:

```text id="c7n2qa"
[1, 8, 6, 2, 5, 4, 8, 3, 7]
```

Initially:

```text id="h6v3sx"
left = 0
right = 8
```

Heights:

```text id="j3w8ka"
height[left] = 1
height[right] = 7
```

The shorter wall is `1`.

Area:

```text id="x5p9mc"
width = 8
height = 1

area = 8 × 1 = 8
```

Since the left wall is shorter, move:

```text id="s2k7vd"
left++
```

We continue this process until the two pointers meet.

The maximum area found is:

```text id="f8r3qm"
49
```

---

## Code

The solution uses two pointers and performs the calculation in a single traversal.

---

## Complexity

* **Time:** O(n)
* **Extra Space:** O(1)

---

## Key Learning

The major lesson from this problem is understanding the **bottleneck principle**.

The shorter wall determines the maximum possible water height.

Therefore, when searching for a better container, we move the pointer at the shorter wall.

This transforms the brute-force O(n²) approach into an efficient **O(n) two-pointer solution**.

---

## Pattern Learned

```text
Two Pointers
     ↓
Start from both ends
     ↓
Calculate current answer
     ↓
Move the limiting pointer
     ↓
Continue until pointers meet
```

This two-pointer pattern is useful in many array and optimization problems.
