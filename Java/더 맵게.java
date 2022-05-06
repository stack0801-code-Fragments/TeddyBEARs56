import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for( int i = 0; i< scoville.length; i++){
            queue.offer(scoville[i]);
        }
        while(queue.peek() < K) {
            System.out.println(queue);
            if (queue.size() == 1)
                return -1;
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(s.solution(scoville,K));
    }
}
