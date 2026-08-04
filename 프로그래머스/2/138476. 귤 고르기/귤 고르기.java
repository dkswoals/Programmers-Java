import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0, i = 0;
        
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer data : tangerine) {
            map.merge(data, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        do {
            answer++;
            k -= map.get(entries.get(i++).getKey());
        } while (k != 0 && k >= 0);

        return answer;
    }
}

