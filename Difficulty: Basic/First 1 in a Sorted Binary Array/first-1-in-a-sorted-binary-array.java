class Solution {
    public int firstIndex(int arr[]) {

        if(arr.length == 0) {
            return -1;
        }
        
        int low = 0; 
        int high = arr.length -1;
        
        int result = Integer.MAX_VALUE;
        
        int mid = (int) (low + high) / 2;
        
        boolean isPresent = false;
        
        while(low <= high) {
            if(arr[mid] == 1) {
                result = Math.min(result, mid);
                high = mid -1;
                isPresent = true;
            }else {
                low = mid + 1;
            }
            
            mid = (int) (low + high) / 2;
        }
        
        return (isPresent ? result : -1);
        
    }
}