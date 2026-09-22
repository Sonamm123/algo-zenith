# Two Sum

**LeetCode:** #1
**Difficulty:** Easy
**Topic:** Arrays, Hashing / HashMap
**Language:** Java

---

## 1. Problem

Given an integer array `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

Each input is guaranteed to have exactly one solution.

### Example

```text
Input:
nums = [2, 7, 11, 15]
target = 9

Output:
[0, 1]
```

Because:

```text
2 + 7 = 9
```

---

## 2. My Initial Thought

My first thought was to use a **brute-force approach**.

I would take one element and compare it with every element after it.

For every pair:

```text
nums[i] + nums[j]
```

I would check whether the sum is equal to the target.

If:

```text
nums[i] + nums[j] == target
```

then I would return the two indices.

---

## 3. Refinement of My Initial Approach

The brute-force approach works, but it requires checking many pairs.

For example:

```text
nums = [2, 7, 11, 15]
target = 9
```

We can check:

```text
2 + 7
2 + 11
2 + 15
7 + 11
...
```

This can become expensive as the array gets larger.

So I looked for a way to determine the second required number directly.

---

## 4. Key Observation

For every current number, we know the target.

Therefore, instead of searching for the second number, we can calculate it:

```text
required = target - current number
```

For example:

```text
target = 9
current number = 7

required = 9 - 7
         = 2
```

Now the question becomes:

> Have I already seen `2`?

This leads to the HashMap approach.

---

## 5. Refined Approach — HashMap

Use a `HashMap` to store:

```text
number → index
```

While traversing the array:

1. Calculate the required number.
2. Check whether that number already exists in the HashMap.
3. If it exists, we have found the required pair.
4. Otherwise, store the current number and its index.
5. Continue traversing.

This avoids repeatedly searching the array.

---

## 6. Algorithm

```text
Create an empty HashMap

for each index i:
    required = target - nums[i]

    if required exists in HashMap:
        return [HashMap[required], i]

    store nums[i] with index i

return empty array
```

---

## 7. Dry Run

Input:

```text
nums = [2, 7, 11, 15]
target = 9
```

### Step 1

```text
i = 0
current = 2

required = 9 - 2
         = 7
```

`7` is not in the map.

Store:

```text
{2 → 0}
```

### Step 2

```text
i = 1
current = 7

required = 9 - 7
         = 2
```

`2` already exists in the map.

Its index is `0`.

Therefore:

```text
[0, 1]
```

---

## 8. Brute Force vs Optimized

| Approach    |    Time |  Space |
| ----------- | ------: | -----: |
| Brute Force | `O(n²)` | `O(1)` |
| HashMap     |  `O(n)` | `O(n)` |

The HashMap approach uses additional memory, but significantly reduces the time required to find the pair.

---

## 9. My Learning

The important shift in thinking was:

> Instead of searching for the second number, calculate what number is required to complete the target.

This introduced the **complement lookup pattern**:

```text
required = target - current
```

and showed how a `HashMap` can make repeated searching much faster.

---

## 10. Key Takeaway

When a problem asks us to find a pair satisfying a target condition, consider:

```text
target - current value
```

and ask whether the required value has already been seen.

This is a common and useful **hashing pattern**.

---

## 11. Java Implementation

See [`Solution.java`](./Solution.java).
