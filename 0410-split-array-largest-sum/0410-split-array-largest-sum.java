class Solution {
    public int splitArray(int[] nums, int k) {

        int min = 0;
        int max = 0;

        int maxOutput = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max += nums[i];

            maxOutput = Math.max(maxOutput, nums[i]);
        }

        if(nums.length == k){
            return maxOutput;
        }

        int mid = (min + max) / 2;

        int result = max;

        while (min <= max) {
            if (isMin(nums, mid, k)) {
                result = Math.min(result, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }

            mid = (min + max) / 2;
        }

        return result;
    }

    public boolean isMin(int[] nums, int mid, int k) {
        int curr = 0;
        int totalParts = 1;

        for (int i = 0; i < nums.length ; i++) {

            if ((curr + nums[i]) <= mid) {
                curr += nums[i];
            } else {
                totalParts++;
                if ((totalParts > k) || (nums[i] > mid)) {
                    return false;
                }
                curr = nums[i];
            }

        }

        return true;
    }

}