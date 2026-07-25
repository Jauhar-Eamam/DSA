class Solution {
    public int findMin(int[] nums) {

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int start = nums[0];
        int result = Integer.MAX_VALUE;

        int low = 0;

        int high = nums.length - 1;

        int mid = (int) (low + high) / 2;

        boolean isRoteted = false;

        if (nums[0] > nums[nums.length - 1]) {
            isRoteted = true;
        } else {
            return nums[0];
        }

        while (low <= high) {

            if (nums[mid] < start) {
                result = Math.min(result, nums[mid]);
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            mid = (int) (low + high) / 2;
        }

        return result;

    }
}