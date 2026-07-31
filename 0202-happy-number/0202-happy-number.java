class Solution {

    public static int findSum(int num){
        int sum = 0;
        while(num > 0){
            int d = num%10;
            num = num / 10;
            sum += d * d;
        }

        return sum;
        
    }

    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        while(fast != 1){
            slow = findSum(slow);
            fast = findSum(fast);
            fast = findSum(fast);

            if(slow == fast && slow != 1){
                return false;
            }
        }
        return true;
    }
}