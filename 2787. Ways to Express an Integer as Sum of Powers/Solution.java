class Solution {
    public int numberOfWays(int n, int x) {
        int mod = 1_000_000_007;

        // Create an array to store the number of ways to sum up to n
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to make 0 (using no numbers)

        // Iterate through each number
        for (int num = 1; Math.pow(num, x) <= n; num++) {
            int power = (int) Math.pow(num, x);

            // Update dp array from back to front
            for (int i = n; i >= power; i--) {
                dp[i] = (dp[i] + dp[i - power]) % mod;
            }
        }

        return dp[n];
    }
}
