class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int low = 0;
        int high = matrix.length - 1;

        int mid1 = (low + high) /2;

        int col = matrix[0].length - 1;

        while(low <= high){
            if(target == matrix[mid1][col]){
                return true;
            }else if(target > matrix[mid1][col]){
                low = mid1 + 1;
            }else {
                if(target == matrix[mid1][0]){
                    return true;
                }else if(target  > matrix[mid1][0]){
                    break;
                }else {
                    high = mid1 - 1;
                }
            }

            mid1 = (low + high) /2;
        }

        low = 0;
        high = col;

        int mid2 = (low + high) / 2;

        while(low <= high) {
            if(target == matrix[mid1][mid2]){
                return true;
            }else if(target > matrix[mid1][mid2]){
                low = mid2 + 1;
            }else {
                high = mid2 - 1;
            }

            mid2 = (low + high) / 2;
        }

        return false;

    }  
}