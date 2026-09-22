# Best Time to Buy and Sell Stock

**LeetCode:** #121
**Difficulty:** Easy
**Topic:** Arrays, Greedy / One-Pass Traversal
**Language:** Java

---

## 1. Problem

Given an array `prices`, where:

```text
prices[i] = stock price on day i
```

choose one day to buy the stock and a later day to sell it.

Return the maximum profit that can be achieved.

If no profit is possible, return `0`.

### Example

```text
Input:
[7, 1, 5, 3, 6, 4]

Output:
5
```

The best transaction is:

```text
Buy at 1
Sell at 6

Profit = 6 - 1 = 5
```

---

## 2. My Initial Thought

Initially, I was not able to see the optimized approach immediately.

I first thought about the relationship between the buying price and selling price.

For a selling price `prices[i]`, the profit would be:

```text
selling price - buying price
```

So the important question became:

> What buying price should I remember while traversing the array?

---

## 3. Refinement of My Thought

I realized that for every selling price, I want the **minimum buying price that appeared before it**.

For example:

```text
prices = [7, 1, 5, 3, 6, 4]
```

When the current price is `5`, the best previous buying price is `1`.

Therefore:

```text
profit = 5 - 1
       = 4
```

When the current price becomes `6`:

```text
profit = 6 - 1
       = 5
```

So instead of checking every possible buy/sell pair, I only need to remember:

```text
minimum buying price seen so far
```

and:

```text
maximum profit seen so far
```

---

## 4. Final Insight

The key insight is:

> **Keep track of the minimum price seen so far and use it to calculate the profit for the current selling price.**

This allows the entire array to be processed in one traversal.

We don't need to check every pair of days.

---

## 5. Final Approach

Maintain two variables:

```text
minPrice
maxProfit
```

For every price:

1. Update `minPrice` if the current price is smaller.
2. Calculate the profit using the current price:

```text
profit = current price - minPrice
```

3. Update `maxProfit` if this profit is larger.
4. Continue until the end of the array.

---

## 6. Algorithm

```text
minPrice = first price
maxProfit = 0

for each price from the second element:

    if price < minPrice:
        minPrice = price

    profit = price - minPrice

    if profit > maxProfit:
        maxProfit = profit

return maxProfit
```

---

## 7. Dry Run

Input:

```text
prices = [7, 1, 5, 3, 6, 4]
```

| Current Price | `minPrice` | Profit | `maxProfit` |
| ------------: | ---------: | -----: | ----------: |
|             7 |          7 |      0 |           0 |
|             1 |          1 |      0 |           0 |
|             5 |          1 |      4 |           4 |
|             3 |          1 |      2 |           4 |
|             6 |          1 |      5 |           5 |
|             4 |          1 |      3 |           5 |

Final answer:

```text
5
```

---

## 8. Why One Traversal Is Enough

At any point in the traversal, we only need two pieces of information from the past:

```text
1. Lowest buying price seen so far
2. Highest profit found so far
```

Everything else from the previous days is unnecessary.

Therefore, we can solve the problem in one pass.

---

## 9. Complexity

* **Time Complexity:** `O(n)`
* **Auxiliary Space Complexity:** `O(1)`

Only two variables are maintained regardless of the size of the input.

---

## 10. My Learning

The main learning from this problem was recognizing that we do not need to compare every possible buying and selling pair.

Instead:

```text
Track the best value seen so far
        ↓
Use it with the current value
        ↓
Update the answer
```

This is a useful pattern for optimization problems involving a sequence and an ordering constraint.

---

## 11. Key Takeaway

When traversing an array, ask:

> **What is the most useful information from the elements I have already seen?**

Here, that information is the **minimum price seen so far**.

That single observation reduces a potentially quadratic solution to a linear one.

---

## 12. Java Implementation

See [`Solution.java`](./Solution.java).
