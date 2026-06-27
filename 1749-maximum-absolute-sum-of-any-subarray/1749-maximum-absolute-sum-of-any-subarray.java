class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int result = Integer.MIN_VALUE;

        int min_result = Integer.MAX_VALUE;
        int max_result = Integer.MIN_VALUE;

        int currMin = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;

        int minSum = 0;
        int maxSum = 0;

        for(int i = 0; i < nums.length; i++){
            minSum+= nums[i];
            maxSum+= nums[i];

            currMin= Math.min(minSum, nums[i]);
            currMax = Math.max(maxSum, nums[i]);

            minSum = currMin;
            maxSum = currMax;

            min_result = Math.min(min_result, currMin);
            max_result = Math.max(max_result, currMax);

            result = Math.max(result, Math.max(max_result, Math.abs(min_result)));

        }

        return (nums.length != 0 ? result : 0);

    }
}