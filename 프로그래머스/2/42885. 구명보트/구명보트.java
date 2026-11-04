import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int i = 0, j = people.length - 1;
        
        Arrays.sort(people);
        
        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++; j--;
            }
            else{
                j--;
            }
            answer++;
        }
        
        return answer;
    }
}

//정렬해서 앞 뒤 합산
//넘으면 무거운 사람 보내기
