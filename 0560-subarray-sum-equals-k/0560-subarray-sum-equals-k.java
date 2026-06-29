import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        int sum = 0;

        int result = 0;

        freq.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            int ques = sum - k;
            int freqResult = freq.getOrDefault(ques, 0);

            result += freqResult;

            freq.put(sum, freq.getOrDefault(sum, 0)+1);

        }

        return (nums.length == 0 ? 0 : result);

    }
}