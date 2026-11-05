import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("^\\{","");
        s = s.replaceAll("\\}$","");
        s = s.replaceAll("\\},\\{", "} {");
        String[] temp = s.split(" ");
        List<List<String>> list = new ArrayList<>();
        for(String subSet : temp){
            String[] t = subSet
                .replaceAll("^\\{","")
                .replaceAll("\\}$","")
                .split(",");
            list.add(new ArrayList<>(Arrays.asList(t)));
        }
        
        Collections.sort(list, (o1, o2) -> {return o1.size() - o2.size();});
        
        int[] answer = new int[list.size()];
        int idx = 0;
        Set<String> set = new HashSet<>();
        for(List<String> i : list){
          for(String j : i){
              if(!set.contains(j)){
                  set.add(j);
                  answer[idx++] = Integer.parseInt(j);
              }
          }
        }
        
        return answer;
    }
}

//부분 집합의 원소 크기별로 정렬
//순서대로 조회하면서 튜블 결과에 이미 있는 원소일 경우 제외, 없는  원소면 포함 후 다음 배열 넘어가기
//원소 체크 hashSet
//정렬? 집합 -> 리스트, 부분집합도 리스트로 변환 ? 시간복잡도가 가능할것인가