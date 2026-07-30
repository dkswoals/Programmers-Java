class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow; i++) {
            int m = i * 2 + (yellow / i * 2) + 4;
            if (m == brown && yellow % i == 0) {
                answer[1] = i + 2;
                answer[0] = yellow / i + 2;
                break;
            }
        }
        return answer;
    }
}