class Solution {
    public int maximumCandies(int[] candies, long k) {


        long result = Integer.MIN_VALUE;

        int min = 1;
        long max = Integer.MIN_VALUE;

        long total = 0;

        for(int i = 0; i < candies.length; i++){
            total += candies[i];

            max = Math.max(max, candies[i]);
        }

        if(total < k) {
            return 0;
        }

        long mid = (min + max) / 2;

        while(min <= max) {

            long child = 0;

            for(int i = 0; i < candies.length; i++){

                if(candies[i] >= mid) {
                    int childs = (int) (candies[i] / mid);
                    child = child + childs;
                        
                    if(child > k){
                        break;
                    }
                }
            }

            if(child >= k) {
                min = (int) mid + 1;
                result = Math.max(result, mid);
            }else{
                max = (int) mid - 1;
            }
            

            mid = (min + max) / 2;
        }

        return (int) result;

    }
}