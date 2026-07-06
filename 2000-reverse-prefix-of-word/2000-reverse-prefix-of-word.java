import java.util.Stack;

class Solution {
    public String reversePrefix(String word, char ch) {

        Stack<Character> stack = new Stack<>();

        StringBuilder str = new StringBuilder();

        boolean isCh = false;

        if(word.indexOf(ch) == -1){
            return word;
        }


        for (int i = 0; i < word.length(); i++) {
            if(isCh == true){
                str.append(word.charAt(i));
                continue;
            }else {
                stack.push(word.charAt(i));
            }

            if ((stack.peek() == ch) && (isCh == false)) {
                isCh = true;
                while (!stack.isEmpty()) {
                    str.append(stack.peek());
                    stack.pop();
                }
            }

            
        }

        return str.toString();

    }
}