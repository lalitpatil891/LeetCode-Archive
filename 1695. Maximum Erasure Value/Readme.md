### 1695. Maximum Erasure Value

You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

**Example 1:**

Input: `nums = [4,2,4,5,6]`
Output: `17`
Explanation: 121 reads as 121 from left to right and from right to left.

**Example 2:**
Input: `nums = [5,2,1,2,5,2,1,2,5]`
Output: `8`
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].


**Constraints:**
`1 <= nums.length <= 105`
`1 <= nums[i] <= 104`

---
Runtime: `53 ms Beats 40.40%`   
Memory: `60.87 MB Beats 43.48%`

*submitted at Jul 22, 2025 17:48*
