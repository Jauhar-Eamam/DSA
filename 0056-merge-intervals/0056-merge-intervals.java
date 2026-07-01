import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int []> result = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){

            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if(end1 >= start2 && end2 >= start1){
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

