import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0, size = priorities.length - 1;
        Deque<Job> deque = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            deque.addLast(new Job(priorities[i], i));
        }

        Arrays.sort(priorities);

        do {
            Job job = deque.removeFirst();
            if (job.priority == priorities[size - answer]) {
                answer++;
                if (job.location == location) {
                    break;
                }
            } else {
                deque.addLast(job);
            }
        } while (!deque.isEmpty());

        return answer;
    }
}

class Job {

    Integer priority;
    Integer location;

    public Job(Integer priority, Integer location) {
        this.priority = priority;
        this.location = location;
    }
}
