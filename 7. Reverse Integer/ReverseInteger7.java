class Solution {
    public int reverse(int x) {
        int num = x;
        int reverse = 0;
        int temp = 0;

        while(num!=0)
        {
            temp = num%10;

            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && temp > 7))
                return 0;
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && temp < -8))
                return 0;

            reverse = reverse*10+temp;
            num /= 10;
        }
        return reverse;
    }
}
