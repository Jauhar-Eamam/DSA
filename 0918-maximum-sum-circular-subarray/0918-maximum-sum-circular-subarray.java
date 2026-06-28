class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int result = nums[0];

        int totalSum = nums[0];

        int currMinSum = nums[0];
        int currMaxSum = nums[0];

        int minResult = Integer.MAX_VALUE;

        for(int i = 1 ; i < nums.length; i++){
            totalSum += nums[i];

            currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
            currMinSum = Math.min(currMinSum + nums[i], nums[i]);

            minResult = Math.min(minResult, currMinSum);

            result = Math.max(result, currMaxSum);

        }

        if(minResult != totalSum && nums.length > 1 ){
            result = Math.max(result, totalSum - minResult);
        } 
 
        return (nums.length != 0 ? result : 0);
        
    }
}