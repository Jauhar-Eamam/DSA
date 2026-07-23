class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = (nums.length)-1;
        int mid = (int) (low+high) / 2;

        while(low <= high) {
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target){
                high = mid-1;
            }else if(nums[mid] < target){
                low = mid+1;
            }

            mid = (int) (low+high) / 2;
        }

        return -1;
        
    }
}