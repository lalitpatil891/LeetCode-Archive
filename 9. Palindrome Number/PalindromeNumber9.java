class Solution {
    public boolean isPalindrome(int x) {
        int number = x;
        int originalNum = x;
        int temp = 0;
        int rev = 0;

        while (number != 0) {
            temp = number % 10;
            rev = rev * 10 + temp;
            number /= 10;
        }

        if (rev < 0) {
            return false;
        } else if (rev == originalNum) {
            return true;
        } else {
            return false;
        }

    }
}
