class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[progresses.length];
        int front = 0, j = 0;
        while (front < progresses.length) {
            int sum = 0;
            for (int i = front; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                if (progresses[i] >= 100 && i == front) {
                    sum++;
                    front++;
                }
            }
            if (sum != 0) {
                temp[j++] = sum;
            }
        }
        int[] answer = new int[j];
        System.arraycopy(temp, 0, answer, 0, j);
        return answer;
    }
}
