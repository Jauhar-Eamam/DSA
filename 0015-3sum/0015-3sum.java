import java.util.*;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> arr = new ArrayList<>();

        int i = 0;

        int k = nums.length - 1;

        int j = 1;

        while (i < nums.length-2) {

            if(i > 0 && nums[i] == nums[i-1]){
                i++;
                 j = i + 1;
                k = nums.length - 1;
                continue;
            }

            if ((j >= k)) {
                i++;
                j = i + 1;
                k = nums.length - 1;
                continue;
            }

            int sum = nums[j] + nums[k];

            if (sum == -(nums[i])) {
                List<Integer> a = new ArrayList<>();
                a.add(nums[i]);
                a.add(nums[j]);
                a.add(nums[k]);
                arr.add(a);
                j++;
                k--;
                while(j < k && nums[j] == nums[j-1]){
                    j++;
                };

                while(j < k && nums[k] == nums[k+1]){
                    k--;
                }
            } else if (sum > -(nums[i])) {
                k--;
            } else if (sum < -(nums[i])) {
                j++;
            }

        }

        return arr;

    }
}