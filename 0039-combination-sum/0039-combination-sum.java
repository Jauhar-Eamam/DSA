class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> arr = new ArrayList<>();

        ArrayList<Integer> tempArr = new ArrayList<>();

        fun(candidates, arr, tempArr, 0, 0, target);

        return arr;
    }

    public static void fun(int[] candidates, List<List<Integer>> arr, ArrayList<Integer> tempArr, int sum, int n,
            int target) {
        if (sum > target) {
            // n++;
            return;
        }

        if (sum == target) {
            arr.add(new ArrayList<> (tempArr));
            // n++;
            return;
        }

        for (int i = n; i < candidates.length; i++) {
            tempArr.add(candidates[i]);
            sum += candidates[i];
            fun(candidates, arr, tempArr, sum, i, target);
            tempArr.remove(tempArr.size() - 1);
            sum -= candidates[i];
        }
        // n--;
        return;
    }

}