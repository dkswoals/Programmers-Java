import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> termTable = new HashMap<>();
        for(String s : terms){
            String[] temp = s.split(" ");
            termTable.put(temp[0], Integer.valueOf(temp[1]));
        }

        int idx = 1;
        List<Integer> list = new ArrayList<>();

        for(String s : privacies){
            String[] temp = s.split(" ");
            String[] day = temp[0].split("\\.");

            String[] target = today.split("\\.");
            int y1 = Integer.valueOf(target[0]) - 1;
            int m1 = Integer.valueOf(target[1]) - 1;
            int d1 = Integer.valueOf(target[2]) - 1;

            int y2 = Integer.valueOf(day[0]) - 1;
            int m2 = Integer.valueOf(day[1]) - 1;
            int d2 = Integer.valueOf(day[2]) - 1;

            int m3 = (m2 + termTable.get(temp[1])) % 12;
            int y3 = y2;
            
            y3 += ((m2 + termTable.get(temp[1])) / 12);

            if(y3 < y1){
                list.add(idx);
            }
            else if(y3 == y1){
                if(m3 < m1){
                    list.add(idx);
                }
                else if(m3 == m1){
                    if(d2 <= d1){
                        list.add(idx);
                    }
                }
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




