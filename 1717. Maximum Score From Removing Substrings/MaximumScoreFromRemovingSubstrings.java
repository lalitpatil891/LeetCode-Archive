import java.util.Stack;

public class Solution {

    // Method to remove given substring pattern (like "ab" or "ba")
    public String removeSubStr(String s, String matchStr) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && ch == matchStr.charAt(1) && st.peek() == matchStr.charAt(0)) {
                st.pop();  // Remove previous character to form the pair
            } else {
                st.push(ch);
            }
        }

        // Reconstruct the remaining string
        StringBuilder temp = new StringBuilder();
        while (!st.isEmpty()) {
            temp.append(st.pop());
        }

        return temp.reverse().toString();  // Reverse to maintain original order
    }

    // Main method to compute maximum gain
    public int maximumGain(String s, int x, int y) {
        int score = 0;

        // Decide which substring gives higher points
        String maxStr = (x > y) ? "ab" : "ba";
        String minStr = (x > y) ? "ba" : "ab";

        // First remove the higher score substring
        String temp_first = removeSubStr(s, maxStr);
        int charRemoved = s.length() - temp_first.length();
        score += (charRemoved / 2) * Math.max(x, y);

        // Then remove the lower score substring
        String temp_second = removeSubStr(temp_first, minStr);
        charRemoved = temp_first.length() - temp_second.length();
        score += (charRemoved / 2) * Math.min(x, y);

        return score;
    }
}
