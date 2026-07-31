class Solution {
    public int findPages(int[] arr, int k) {
        
        if(arr.length < k) {
            return -1;
        }
        
        long result = Integer.MAX_VALUE;
        
        int minPage = Integer.MIN_VALUE;
        long maxPage = 0;
        
        for(int i = 0; i < arr.length; i++){
            minPage = Math.max(minPage, arr[i]);
            maxPage += arr[i];
        }
        
        long mid = (minPage + maxPage) / 2;
        
        
        
        while(minPage <= maxPage) {
        int student = 1;
        int totalPage = 0;
            
            for(int i = 0; i < arr.length; i++){
                
                if((totalPage + arr[i]) <= mid){
                    totalPage += arr[i];
                }else {
                    student++;
                    if(student > k) {
                        minPage = (int) mid + 1;
                        break;
                    }
                    totalPage = arr[i];
                }
                
            }
            
            if(student > k){
                minPage = (int) mid + 1;
            }else {
                maxPage = mid - 1;
                result = Math.min(result, mid);
            }
            
            
            mid = (minPage + maxPage) / 2;
        }
        
        
        return (int)result;
    }
}