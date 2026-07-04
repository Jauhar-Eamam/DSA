import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        boolean result = true;

        int n = s.length();

        if(n%2 != 0){
            return false;
        }

        for(int i = 0; i < n; i++){

            char ch = s.charAt(i);

            if((ch == '(') || (ch == '{') || (ch == '[') ){
                stack.push(s.charAt(i));
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            if((stack.peek() == '(') && s.charAt(i) == ')' ){
                stack.pop();
                continue;
            }else if((stack.peek() == '{') && s.charAt(i) == '}') {
                stack.pop();
                continue;
            }else if((stack.peek() == '[') && s.charAt(i) == ']'){
                stack.pop();
                continue;
            }else {
                return false;
            }

            
        }

        if(stack.isEmpty() == false){
            return false;
        }

        return true;

    }
}