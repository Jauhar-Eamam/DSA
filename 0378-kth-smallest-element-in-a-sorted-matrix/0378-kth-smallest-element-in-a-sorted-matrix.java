class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int min = matrix[0][0];
        int max = matrix[matrix.length - 1][matrix.length - 1];

        int mid = min + (max - min) / 2;

        int result = max;

        while (min <= max) {
            if (isLessThenK(matrix, mid, k)) {
                result = Math.min(result, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }

            mid = min + (max - min) / 2;
        }

        return result;

    }

    public boolean isLessThenK(int[][] matrix, int mid, int k) {
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        int lessThenMid = 0;

        while(row >= 0 && col < n) {

            if(matrix[row][col] <= mid){
                lessThenMid += row + 1;
                col++;
            }else {
                row--;
            }
        }

        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix.length; j++) {
        //         if (matrix[i][j] <= mid) {
        //             lessThenMid++;
        //         }
        //     }
        // }

        return lessThenMid >= k;

        
    }
}