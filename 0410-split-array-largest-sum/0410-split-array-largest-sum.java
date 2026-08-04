class Solution {
    public int splitArray(int[] nums, int k) {

        int minValue = 0;
        int maxValue = 0;

        int maxOutput = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxValue += nums[i];

            maxOutput = Math.max(maxOutput, nums[i]);
        }

        if(nums.length == k){
            return maxOutput;
        }

        int midValue = (minValue + maxValue) / 2;

        int result = maxValue;

        while (minValue <= maxValue) {
            if (isMin(nums, midValue, k)) {
                result = Math.min(result, midValue);
                maxValue = midValue - 1;
            } else {
                minValue = midValue + 1;
            }

            midValue = (minValue + maxValue) / 2;
        }

        return result;
    }

    public boolean isMin(int[] nums, int midValue, int k) {
        int currValue = 0;
        int totalParts = 1;

        for (int i = 0; i < nums.length ; i++) {

            if ((currValue + nums[i]) <= midValue) {
                currValue += nums[i];
            } else {
                totalParts++;
                if ((totalParts > k) || (nums[i] > midValue)) {
                    return false;
                }
                currValue = nums[i];
            }

        }

        return true;
    }

}