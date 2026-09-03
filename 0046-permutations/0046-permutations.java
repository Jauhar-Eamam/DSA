class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> arr = new ArrayList<>();

        ArrayList<Integer> tempArr = new ArrayList<>();

        fun(nums, arr, tempArr);

        return arr;
        
    }

    public static void fun(int[] nums, List<List<Integer>> arr, ArrayList<Integer> tempArr) {


        if(tempArr.size() == nums.length) {
            arr.add(new ArrayList(tempArr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
             if(tempArr.contains(nums[i])){
            continue;
        }
            tempArr.add(nums[i]);

            fun(nums, arr, tempArr);
            tempArr.remove(tempArr.size() - 1);
        }

        return;
    }
}