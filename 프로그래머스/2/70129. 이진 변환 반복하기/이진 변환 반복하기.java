class Solution {
    public int[] solution(String s) {
         int[] answer = {0, 0};

        while (!s.equals("1")) {
            int count = 0;
            answer[0]++;
            count = (int) (s.chars().filter(ch -> ch == '0').count());
            answer[1] += count;
            s = intsToBinaryString(s.length() - count);
        }

        return answer;
    }

    private static String intsToBinaryString(int n) {
        int bin = 0;
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            bin = n % 2;
            n /= 2;
            result.append(bin);
        }
        return result.reverse().toString();
    }
}