class Solution {
    public int aggressiveCows(int[] arr, int k) {
        
        if(arr.length < k){
            return -1;
        }
        
        Arrays.sort(arr);
        
        int start = 1;
        int end = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            end = Math.max(end, arr[i]);
        }
        
        int mid = (start + end) / 2;
        
        int distance = Integer.MIN_VALUE;
        
        while(start <= end) {
            int stIndx = 0;
            int cows = 1;
            
            for(int i = 1; i < arr.length; i++){
                if(Math.abs(arr[stIndx] - arr[i])  >= mid){
                    cows++;
                    stIndx = i;
                }
            }
            if(cows >= k){
                start = mid + 1;
                distance = Math.max(distance, mid);
            }else {
                end = mid - 1;
            }
            
            mid = (start + end) / 2;
        }
        
        return distance;
        
    }
}