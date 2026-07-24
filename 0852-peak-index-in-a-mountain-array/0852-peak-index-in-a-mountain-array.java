class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int low = 0;
        int high = arr.length - 1;

        int mid = (int) (low + high) /2;

        int peak = Integer.MAX_VALUE;

        while(low <= high){

            if(arr[mid] > arr[mid+1]){
                peak = Math.min(peak, mid);
                high = mid - 1;
            }else {
                low = mid + 1;
            }

            mid = (int) (low + high) / 2;
        }

        return (arr.length != 0 ? peak : 0);
    }
}