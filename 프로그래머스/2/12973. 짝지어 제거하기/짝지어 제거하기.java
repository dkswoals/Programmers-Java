class Solution
{
    public int solution(String s)
    {
       char[] stack = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (top == -1 || c != stack[top]) {
                stack[++top] = c;
            } else {
                top--;
            }
        }
        return top == -1 ? 1 : 0;
    }
}