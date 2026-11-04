import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sumQ1 = 0;
        long sumQ2 = 0;
        long limit = (queue1.length + queue2.length) * 4;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(Integer i : queue1){
            q1.add(i);
            sumQ1 += i;
        }
        
         for(Integer i : queue2){
            q2.add(i);
            sumQ2 += i;
        }
        
        if((sumQ1 + sumQ2) % 2 > 0){
            return -1;
        }
        
        while(sumQ1 != sumQ2){
            if(q1.isEmpty() || q2.isEmpty()) return -1;
            if(answer > limit) return -1;
            if(sumQ1 > sumQ2){
                int poped = q1.remove();
                q2.add(poped);
                sumQ1 -= poped;
                sumQ2 += poped;
            }
            else{
                int poped = q2.remove();
                q1.add(poped);
                sumQ2 -= poped;
                sumQ1 += poped;
            }
            answer++;
        }
        
        return answer;
    }
}

//두 큐의 원소 합을 동일하게?
//브루드포스 불가능
//a_sum = b_sum
//a1 + a2 + a3 == b1 + b2
//모든 원소 합이 홀수면 -1
//합이 큰쪽에서 작은쪽으로 pop