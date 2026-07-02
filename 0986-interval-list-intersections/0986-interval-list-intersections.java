import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        ArrayList<int []> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length){
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            if(start1 <= start2){
                if(end1 >= start2){
                    int currStart = Math.max(start1, start2);
                    int currEnd = Math.min(end1, end2);

                    result.add(new int[]{currStart, currEnd});
                }
            }else {
                    // start1 > start2
                    if(end2 >= start1){
                        int currStart = Math.max(start1, start2);
                        int currEnd = Math.min(end1, end2);

                        result.add(new int[]{currStart, currEnd});
                    }
                }

                if(end1 < end2){
                    i++;
                }else{
                    j++;
                }
        }

        return result.toArray(new int[result.size()][]);
        
    }
}