class Solution {
    int countFreq(int[] arr, int target) {
        
        if(arr.length == 0){
            return 0;
        }
        
        int low1 = 0;
        int high1 = arr.length -1 ;
        
        int low2 ;
        int high2;
        
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        boolean isPresent = false;
        
        int mid = (int) (low1 + high1) /2;
        
        while(low1 <= high1) {
            
            if(arr[mid] == target) {
                isPresent = true;
                break;
            }else if (arr[mid] > target) {
                high1 = mid - 1;
            }else {
                low1 = mid + 1;
                
            }
            
            mid = (int) (low1 + high1) / 2;
        }
        
        if(!isPresent){
            return 0;
        }
        
        low1 = 0; 
        high1 = mid;
        
        int mid1 = (int) (low1 + high1) / 2;
        
        while(low1 <= high1) {
            if(arr[mid1] == target) {
                start = Math.min(start, mid1);
                high1 = mid1 -1;
            }else if(arr[mid1] < target) {
                low1 = mid1 + 1;
            }
            
            mid1 = (int) (low1 + high1) / 2;
        }
        
        low2 = mid;
        high2 = arr.length-1;
        
        int mid2 = (int) (low2 + high2) / 2;
        
        while(low2 <= high2) {
            if(arr[mid2] == target ){ 
                end = Math.max(end, mid2);
                low2 = mid2 + 1;
                
            }else if(arr[mid2] > target) {
                high2 = mid2 - 1;
            }
            
            mid2 = (int) (low2 + high2 ) / 2;
        }
        
        return (end-start) + 1;
    }
}
