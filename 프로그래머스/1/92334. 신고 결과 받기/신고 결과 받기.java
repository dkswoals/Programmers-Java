import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> reported = new HashMap<>();
        Map<String, Integer> idxTable = new HashMap<>();
        int idx = 0;
        for(String s : id_list){
            reported.put(s, new HashSet<>());
            idxTable.put(s, idx++);
        }
        
        for(String s : report){
            String[] temp = s.split(" ");
            reported.get(temp[1]).add(temp[0]);
        }
        
        for(String t : id_list){
           Set<String> list = reported.get(t);
            if(list.size() >= k){
                for(String s : list){
                    answer[idxTable.get(s)]++;
                }
            }
        }
        
        return answer;
    }
}