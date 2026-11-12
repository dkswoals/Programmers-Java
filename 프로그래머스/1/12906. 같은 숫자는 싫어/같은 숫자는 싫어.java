import java.util.*;

public class Solution {
   public int[] solution(int[] arr) {
        int[] temp = new int[arr.length + 1];
        int j = 0;
        for (int k : arr) {
            if (j == 0 || (k != temp[j - 1])) {
                temp[j++] = k;
            }
        }
        int[] answer = new int[j];
        for (int i = 0; i < j; i++) {
            answer[i] = temp[i];
        }
        return answer;
    }
}