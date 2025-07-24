//3622. Check Divisibility by Digit Sum and Product

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
