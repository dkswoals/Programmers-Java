import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        int idx = 1;
        Map<String, Integer> termTable = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(String s : terms){
            String[] temp = s.split(" ");
            termTable.put(temp[0], Integer.valueOf(temp[1]));
        }
        String[] t = today.split("\\.");
        int todayParsed = (Integer.valueOf(t[0]) * 12 * 28) + (Integer.valueOf(t[1]) * 28) + Integer.valueOf(t[2]);
        
        for(String s : privacies){
            String[] temp = s.split(" ");
            String[] day = temp[0].split("\\.");
            
            int privaciesParsed = (Integer.valueOf(day[0]) * 12 * 28) + (Integer.valueOf(day[1]) * 28) + Integer.valueOf(day[2]) + (termTable.get(temp[1]) * 28);
            
            
            if(privaciesParsed <= todayParsed){
                list.add(idx);
            }
            
            idx++;
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        idx = 0;
        for(Integer i : list){
            answer[idx++] = i;
        }

        return answer;
    }
}




