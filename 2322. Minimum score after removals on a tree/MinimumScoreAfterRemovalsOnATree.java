import java.util.*;

class Solution {
    private List<Integer>[] tree;
    private int[] subtreeXor;
    private int[] tin, tout;
    private int timer = 0;
    private int totalXor;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;

        // Step 1: Build adjacency list
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        subtreeXor = new int[n];
        tin = new int[n];
        tout = new int[n];

        // Step 2: DFS to compute subtree XOR and entry/exit times
        dfs(0, -1, nums);
        totalXor = subtreeXor[0];

        int minScore = Integer.MAX_VALUE;

        // Step 3: Try all unordered pairs of edges (represented by child nodes)
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x, y, z;
                if (isAncestor(i, j)) {
                    // i is ancestor of j
                    x = subtreeXor[j];
                    y = subtreeXor[i] ^ subtreeXor[j];
                    z = totalXor ^ subtreeXor[i];
                } else if (isAncestor(j, i)) {
                    // j is ancestor of i
                    x = subtreeXor[i];
                    y = subtreeXor[j] ^ subtreeXor[i];
                    z = totalXor ^ subtreeXor[j];
                } else {
                    x = subtreeXor[i];
                    y = subtreeXor[j];
                    z = totalXor ^ x ^ y;
                }

                minScore = Math.min(minScore, getScore(x, y, z));
            }
        }
        return minScore;
    }

    // Helper to compute score = max - min
    private int getScore(int x, int y, int z) {
        int max = Math.max(x, Math.max(y, z));
        int min = Math.min(x, Math.min(y, z));
        return max - min;
    }

    // DFS to compute subtree XOR and record tin/tout for ancestor check
    private void dfs(int node, int parent, int[] nums) {
        tin[node] = timer++;
        subtreeXor[node] = nums[node];

        for (int child : tree[node]) {
            if (child != parent) {
                dfs(child, node, nums);
                subtreeXor[node] ^= subtreeXor[child];
            }
        }

        tout[node] = timer++;
    }

    // Check if u is an ancestor of v using tin/tout time
    private boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }
}

public class MinimumScoreAfterRemovalsOnATree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 5, 5, 4, 11};
        int[][] edges = {{0,1},{1,2},{1,3},{3,4}};
        System.out.println(sol.minimumScore(nums, edges));
    }
}
