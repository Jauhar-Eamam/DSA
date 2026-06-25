class Solution {
    public int maximumSum(int[] arr) {
        
        int result = Integer.MIN_VALUE;

        int noDelete= arr[0];
        int oneDelete = 0;

        int nodeal;
        int onedeal;

        if(arr.length == 1){
            return arr[0];
        } else if(arr.length == 0){
            return 0;
        }



        for(int i = 1; i < arr.length; i++){
                nodeal = noDelete;
                noDelete = Math.max(nodeal + arr[i], arr[i]);

                onedeal = oneDelete;

            oneDelete = Math.max(onedeal + arr[i], nodeal);

            result = Math.max(result, Math.max(noDelete, oneDelete));
        }

        return result;
    }
}