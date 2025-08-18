## LeetCode 1323: Maximum 69 Number

Given a positive integer made up of only 6s and 9s, change at most one digit (6 to 9 or 9 to 6) to get the maximum number possible.

## Example
- **Input:** `9669`
- **Output:** `9969`

## Solution Approach
1. Convert the number to a string.
2. Change the first '6' you see to '9'.
3. Convert it back to an integer.

## Java Code
```java
class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        s = s.replaceFirst("6", "9");
        return Integer.parseInt(s);
    }
}
```
