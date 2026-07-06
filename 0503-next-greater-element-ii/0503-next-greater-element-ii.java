import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int result[]  = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() > nums[i]) {
                    result[i] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            }
            stack.push(nums[i]);
        }

        return result;

    }
}