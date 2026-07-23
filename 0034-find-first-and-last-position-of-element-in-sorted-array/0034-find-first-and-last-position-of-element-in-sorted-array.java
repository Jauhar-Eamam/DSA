class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low1 = 0;
        int low2;

        int high1 = nums.length -1;
        int high2;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        int mid = (int) (low1 + high1) / 2;

        boolean isPresent = false;

        while(low1 <= high1) {
            if(nums[mid] == target){
                isPresent = true;
                break;
            }else if(nums[mid] > target){
                high1 = mid - 1;
            }else {
                low1 = mid +1;
            }

            mid = (int) (low1 + high1) / 2;
        }

        if(!isPresent){
            int result[] = {-1, -1};
            return result;
        }

        low1 = 0;
        high1 = mid;

        int mid1 = (int) (low1 + high1) / 2;

        while(low1 <= high1) {
            if(nums[mid1] == target) {
                start = Math.min(start, mid1);
                high1 = mid1 - 1;
            }else if(nums[mid1] < target) {
                low1 = mid1 + 1;
            }

            mid1 = (int) (low1 + high1) / 2;
        }

        low2 = mid;
        high2 = nums.length -1 ;

       int mid2 = (int) (low2 + high2) / 2;

        while(low2 <= high2) {
            if(nums[mid2] == target) {
                end = Math.max(end, mid2);
                low2 = mid2 + 1;
            }else if(nums[mid2] > target){
                high2 = mid2 - 1;
            }

            mid2 = (int) (low2 + high2) / 2;
        }

        int result[] = {start, end};

        return result;

    }
}