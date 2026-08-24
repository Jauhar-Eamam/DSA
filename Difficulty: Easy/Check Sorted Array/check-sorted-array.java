class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        return checkShorted(arr, 1);
    }
    
    public boolean checkShorted(int[] arr, int indx){
        if(indx == arr.length){
            return true;
        }
        
        if(arr[indx - 1] > arr[indx]){
            return false;
        }
        
        return checkShorted(arr, indx+1);
    }
}