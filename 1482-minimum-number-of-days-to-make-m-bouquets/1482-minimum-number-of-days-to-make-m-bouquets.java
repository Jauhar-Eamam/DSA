class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long totalneed =  m * (long)k;

        if(bloomDay.length < totalneed){
            return -1;
        }

        int start = 1;

        int end = Integer.MIN_VALUE;

        for(int i = 0; i < bloomDay.length; i++){
            end = Math.max(end, bloomDay[i]);
        }

        int mid = (start + end) / 2;

        int result = Integer.MAX_VALUE;

        while(start <= end) {

            int max = Integer.MIN_VALUE;

            int count = 0;

            int boucket = 0;

            for(int i = 0; i < bloomDay.length; i++){

                if(bloomDay[i] <= mid){
                    count++;
                }else {
                    count = 0;
                }

                if(count == k){
                    boucket++;
                    count = 0;
                }
            }

            if(boucket < m){
                start = mid + 1;
            }else {
                end = mid - 1;
                result = Math.min(result, mid);
            }

            mid = (start + end) / 2;
            
        }

        return result;
        
    }
}