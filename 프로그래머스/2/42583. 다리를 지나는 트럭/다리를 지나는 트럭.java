class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, currentWeight = 0;
        int front = 0, rear = bridge_length - 1, i = 0;
        int[] bridge = new int[bridge_length + 1];

        while (i < truck_weights.length) {
            answer++;
            front = (front + 1) % bridge_length;
            rear = (rear + 1) % bridge_length;
            if (currentWeight + truck_weights[i] <= weight) {
                currentWeight += truck_weights[i];
                bridge[rear] = truck_weights[i++];
            } else {
                bridge[rear] = 0;
            }
            currentWeight -= bridge[front];
        }
        return answer + bridge_length;
    }
}