import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        List<String> list = new ArrayList<>();
        for(Integer i : numbers){
            list.add(i.toString());
        }
        
        Collections.sort(list, (o1, o2) -> {
            Integer sum1 = Integer.parseInt(o1 + o2);
            Integer sum2 = Integer.parseInt(o2 + o1);
            return sum2 - sum1;
        });
        
        if(list.getFirst().equals("0"))return "0";
        
        String answer = String.join("",list);
        
        
        return answer;
    }
}

//정렬 기준: 첫번째 자리수가 크면 큼, 같으면 다음 자리 비교
//길이가 다르다면? 길이 다른데 자리수 같으면 짧은게 우선 -> 틀림
//짧은 수의 마지막 자리수랑 다음 자리 비교