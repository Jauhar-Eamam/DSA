class Solution {
    public int maxProduct(int[] nums) {

        int result = Integer.MIN_VALUE;

        int maxCurrRes;
        int minCurrRes;

        int maxProd = 1;
        int minProd = 1;

        for(int i = 0; i < nums.length; i++){

            maxProd *= nums[i];
            minProd *= nums[i];

            maxCurrRes = Math.max(nums[i],Math.max(maxProd, minProd));
            minCurrRes = Math.min(nums[i], Math.min(maxProd, minProd));

            maxProd = maxCurrRes;
            minProd = minCurrRes;

            result = Math.max(result, Math.max(maxCurrRes, minCurrRes));
        }

        return result;
        
    }
}