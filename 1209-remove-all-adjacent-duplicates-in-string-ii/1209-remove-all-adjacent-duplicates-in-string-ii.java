import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<int[]> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        stack.push(new int[] {s.charAt(0), 1});

        for(int i = 1; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(new int[] {s.charAt(i), 1});
                continue;
            }

            if((char) stack.peek()[0] != s.charAt(i)){
                stack.push(new int[] {s.charAt(i), 1});
                continue;
            }

            if((char) stack.peek()[0] == s.charAt(i)){
                if(stack.peek()[1] == k-1){
                    stack.pop();
                }else{
                    stack.peek()[1]++;
                }
            }
        }

        while(!stack.isEmpty()){
            while(stack.peek()[1] > 0){
                result.append((char) stack.peek()[0]);
                stack.peek()[1]--;
            }
            stack.pop();
        }
        result.reverse();

        return result.toString();

    }
}