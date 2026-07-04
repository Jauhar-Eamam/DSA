import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        StringBuilder str = new StringBuilder();

        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }

        while(!stack.isEmpty()){
            str.append(stack.peek());
            stack.pop();
        }

        str.reverse();

        return str.toString();
    }
}