class Solution {
    boolean solution(String s) {
       int top = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                top++;
            } else if (c == ')') {
                if (top <= 0) {
                    return false;
                }
                top--;
            }
        }
        return top == 0;
    }
}