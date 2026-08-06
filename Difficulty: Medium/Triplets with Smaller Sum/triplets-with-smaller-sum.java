import java.util.*;


class Solution {
    int countTriplets(int sum, int arr[]) {
        
        int count = 0;
        
        Arrays.sort(arr);
        
        int i = 0;
        int j = 1;
        int k = arr.length-1;
        
        while(i < arr.length -2){
            
            if( i > 0 && arr[i] == arr[i-1]){
                i++;
                j = i + 1;
                k = arr.length-1;
                continue;
            }
            
            if( j >= k) {
                i++;
                j = i + 1;
                k = arr.length-1;
                continue;
            }
            
            int minSum = arr[i] + arr[j] + arr[k];
            
            if( sum <= minSum){
                k--;
            }
            else{
                count = count + (k-j);
                j++;
            }
        }
        
        return count;
    }
}