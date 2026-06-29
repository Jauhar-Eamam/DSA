class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length-1;

        int left = 0;
        int right;

        int sum = 0;

        for(int i = 0; i <=n; i++){
            sum += nums[i];
        }

        for(int i = 1; i <= n; i++){

            if(i-1 == 0){
                right = sum - nums[i-1]-left;
                if(left == right){
                    return 0;
                }
            }

            left += nums[i-1];
            right = sum - nums[i] - left;

            if(left == right){
                return i;
            }
            
            
        }

        return n == 0 ? 0 : -1;
        
    }
}