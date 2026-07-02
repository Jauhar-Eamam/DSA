import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int []> list = new ArrayList<>();

        if(intervals.length == 0 && newInterval.length == 0){
            return list.toArray(new int[0][]);
        }else if(intervals.length == 0){

            list.add(new int[]{newInterval[0], newInterval[1]});
            return list.toArray(new int[0][]);
        }else if(newInterval.length == 0) {
            return intervals;
        }


        int start1;
        int end1;

        boolean inserted = false;

        for(int i = 0; i < intervals.length; i++){

            start1 = intervals[i][0];
            end1 = intervals[i][1];

            if(inserted == false && start1 >= newInterval[0]){
                list.add(new int[]{newInterval[0], newInterval[1]});

                list.add(new int[]{start1, end1}); 
                inserted = true;       
            }

            list.add(new int[]{start1, end1});

           
        }

        if(inserted == false){
            list.add(new int[]{newInterval[0], newInterval[1]});
        }

        ArrayList<int []> result = new ArrayList<>();

        start1 = list.get(0)[0];
        end1 = list.get(0)[1];

        for(int i = 1 ; i < list.size(); i++){
            int start2 = list.get(i)[0];
            int end2 = list.get(i)[1];

            if(end1 >= start2){
                start1 = Math.min(start1, start2);
                end1 = Math.max(end1, end2);
                continue;
            }

            result.add(new int[]{start1, end1});

            start1 = start2; 
            end1 = end2;
        }

        result.add(new int[]{start1, end1});

        return result.toArray(new int[result.size()][]);
        
    }
}