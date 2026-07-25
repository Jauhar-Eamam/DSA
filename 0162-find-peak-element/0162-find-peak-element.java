class Solution {
    public int findPeakElement(int[] nums) {

        if(nums.length == 1){
            return 0;
        }

        if(nums[0] > nums[1]){
            return 0;
        }else if(nums[nums.length - 2] < nums[nums.length - 1]){
            return nums.length - 1;
        }
        
        int peak = Integer.MAX_VALUE;

        int low = 1;
        int high = nums.length - 2 ;

        int mid = (int) (low + high) / 2;

        while(low <= high) {

            if(nums[mid] > nums[mid + 1]){
                peak = Math.min(peak, mid);
                high = mid - 1;
            }else {
                low = mid + 1;
            }

            mid = (int) (low + high) / 2;
        }

        return (nums.length != 0 ? peak : 0);
    }
}