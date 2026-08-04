import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int i = 0, j = people.length - 1;
        Arrays.sort(people);
        while (i <= j) {
            if (limit == people[j] || limit < people[j] + people[i]) {
                j--;
                answer++;
            } else if (limit >= people[i] + people[j]) {
                i++;
                j--;
                answer++;
            }
        }
        return answer;
    }
}
