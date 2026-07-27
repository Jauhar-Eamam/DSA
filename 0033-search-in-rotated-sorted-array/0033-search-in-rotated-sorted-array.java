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
                    if(nums[mid] >= start){
                    low = mid + 1;
                    }else {
                        high = mid - 1;                    }
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
                    if(nums[mid] >= start){
                    low  = mid + 1;
                    }else {
                        high = mid - 1;
                    }
                }

                mid = (low + high) / 2;
            }
        }

        return -1;

        // while (low <= high) {
        //     if(nums[mid] > target){
        //         if(start > target) {
        //             low = mid + 1;
        //         }else if(start < target) {
        //             high = mid - 1;
        //         }else{
        //             return 0;
        //         }
        //     }else if(nums[mid] < target) {
        //         if(start > nums[mid]){

        //         }
        //     }

        //     if (nums[mid] >= start) {
        //         low = mid + 1;
        //     } else {
        //         high = mid - 1;
        //         index = Math.min(index, mid);
        //         isIndex = true;
        //     }

        //     mid = (low + high) / 2;
        // }

        // low = 0;
        // high = (isIndex ? index - 1 : nums.length - 1);

        // mid = (low + high) / 2;

        // while (low <= high) {
        //     if (nums[mid] < target) {
        //         low = mid + 1;
        //     } else if (nums[mid] > target) {
        //         high = mid - 1;
        //     } else {
        //         return mid;
        //     }

        //     mid = (low + high) / 2;
        // }

        // low = (isIndex ? index : 0);
        // high = nums.length - 1;

        // mid = (low + high) / 2;

        // while (low <= high) {
        //     if (nums[mid] < target) {
        //         low = mid + 1;
        //     } else if (nums[mid] > target) {
        //         high = mid - 1;
        //     } else {
        //         return mid;
        //     }

        //     mid = (low + high) / 2;
        // }

        // return -1;

    }

}