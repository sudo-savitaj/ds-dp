import java.util.Stack;

public class LongestValidParantheses {

    public int longestValidParenthesesRecursive(String s) {
        return longestValidParenthesesRecursive(s, 0, 0) * 2;
    }

    private int longestValidParenthesesRecursive(String str, int open, int close) {
        if (str.length() == 0) return Integer.min(open, close);
        if (str.charAt(0) == '(') return longestValidParenthesesRecursive(str.substring(1), open + 1, close);
        else if (close < open) return longestValidParenthesesRecursive(str.substring(1), open, close + 1);
        else return longestValidParenthesesRecursive(str.substring(1), open, close);
    }

    public int longestValidParentheses(String str) {
        int len = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String subString = str.substring(i, j + 1);
                if (isValid(subString) && len < subString.length()) len = subString.length();
            }
        }
        return len;
    }

    boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                stack.push(str.charAt(i));
            else if (str.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
            } else
                return false;
        }
        return stack.isEmpty();
    }

    public int longestValidParenthesesUsingStack(String str) {
        Stack<Integer> stack = new Stack();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else {
                    int len = i - stack.peek();
                    if (max < len) max = len;
                }
            }
        }
        return max;
    }

    //()()
    public int longestValidParenthesesDP(String str) {
        int[] t = new int[str.length()];
        int max = 0;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == ')'){
                if(str.charAt(i-1)=='(')
                    t[i] = (i>= 2 ? t[i-2] : 0 ) + 2;
                else if (i-t[i-1]>0 && str.charAt(i-t[i-1]-1)=='(')
                    t[i] = t[i-1] + 2 + (i-t[i-1] >=2 ? t[i-t[i-1]-2]:0);

                if(t[i] > max)
                    max = t[i];
            }
        }

        return max;
    }

    public void display() {
//        System.out.println("test".substring(0,2));
        int len = longestValidParenthesesDP("()(())");
        System.out.println(len);
    }
}

