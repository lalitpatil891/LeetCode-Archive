### 3622. Digit Sum and Product Divisibility Check

### 🧩 Problem Statement

Given a **positive integer** `n`, determine whether it is divisible by the **sum of the following two values**:

* The **sum of its digits**, and
* The **product of its digits**.

Return `true` if `n` is divisible by this total sum; otherwise, return `false`.

---

### ✅ Example 1

**Input:**
`n = 99`
**Output:**
`true`

**Explanation:**
Digits: `9` and `9`

* Digit Sum = `9 + 9 = 18`
* Digit Product = `9 * 9 = 81`
* Total = `18 + 81 = 99`
  Since `99 % 99 == 0`, the answer is `true`.

---

### ✅ Example 2

**Input:**
`n = 23`
**Output:**
`false`

**Explanation:**
Digits: `2` and `3`

* Digit Sum = `2 + 3 = 5`
* Digit Product = `2 * 3 = 6`
* Total = `5 + 6 = 11`
  Since `23 % 11 != 0`, the answer is `false`.

---

### 💡 Approach

1. Extract each digit of `n` using modulo and division.
2. Compute:

   * `digitSum` → sum of all digits
   * `digitProduct` → product of all digits
3. Check if `n` is divisible by `digitSum + digitProduct`.

---

### 🧪 Java Code

```java
class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int mul = 1;
        int sum = 0;

        while(num != 0){
            int temp = num % 10;
            sum += temp;
            mul *= temp;
            num /= 10;
        }

        return n % (sum + mul) == 0;
    }
}
```

---

### 📦 Test Cases

```java
System.out.println(new Solution().checkDivisibility(99)); // true
System.out.println(new Solution().checkDivisibility(23)); // false
System.out.println(new Solution().checkDivisibility(1));  // true (1 / (1+1) = not divisible → false)
System.out.println(new Solution().checkDivisibility(36)); // true (3+6=9, 3*6=18, 9+18=27, 36%27==9 → false)
```
