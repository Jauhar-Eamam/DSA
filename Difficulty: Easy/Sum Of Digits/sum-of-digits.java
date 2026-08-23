class Solution {
    static int sumOfDigits(int n) {
        
        if(n <= 0) {
            return 0;
        }
        // code here
        int lastDigit = n%10;
        
        int lastResult = sumOfDigits(n/10);
        
        return lastResult + lastDigit;
    }
}
