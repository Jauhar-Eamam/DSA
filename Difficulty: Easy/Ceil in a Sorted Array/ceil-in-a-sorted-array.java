class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        
        if(arr.length == 0){
            return -1;
        }else if(x == 0){
            return 0;
        }
        
        
        int smallest = Integer.MAX_VALUE;
        
        int low = 0;
        int high = arr.length-1;
        int mid = (int) (low+high) / 2;
        
        boolean isSmallest = false;
        
        while(low <= high) {
            if(arr[mid] == x) {
                smallest = Math.min(smallest, mid);
                high = mid-1;
                isSmallest = true;
            }else if(arr[mid] < x){
                low = mid+1;
            }else{
                high = mid-1;
                smallest = Math.min(smallest, mid);
                isSmallest = true;
            }
            mid = (int) (low + high) /2 ;
        }
        
        
        
        return (isSmallest ? smallest : -1);
    }
}
