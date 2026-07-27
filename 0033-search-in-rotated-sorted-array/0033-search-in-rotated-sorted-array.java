class Solution {
    public int search(int[] nums, int target) {

        int index = Integer.MAX_VALUE;

        int low = 0;

        int high = nums.length - 1;
        int mid = (low + high) / 2;

        boolean isIndex = false;

        if (nums[0] < nums[high]) {
            while (low <= high) {
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    return mid;
                }

                mid = (low + high) / 2;
            }

            return -1;
        }

        int start = nums[0];

        if (target >= start) {
            while (low <= high) {

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    if (nums[mid] >= start) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else if (nums[mid] > target) {

                    high = mid - 1;
                }

                mid = (low + high) / 2;
            }
        } else {
            while (low <= high) {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    if (nums[mid] >= start) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                mid = (low + high) / 2;
            }
        }

        return -1;

    }
}