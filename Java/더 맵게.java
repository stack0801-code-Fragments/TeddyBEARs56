import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();    // 우선순위 큐 사용 : 그냥 큐 사용할 경우 sort해야하는데 어느정도 정렬이 가능하기 때문에 사용해봄
        for( int i = 0; i< scoville.length; i++){
            queue.offer(scoville[i]);   // 큐에 정렬된 배열 값 넣기
        }
        while(queue.peek() < K) {       // 큐 맨 앞의 값이 K수준 보다 높아질 때 까지 반복
            if (queue.size() == 1)      // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
                return -1;
            queue.add(queue.poll() + queue.poll() * 2); // 맨앞의 두 수를 연산하여 큐 맨뒤에 삽입
            answer++;                   // 횟수 카운트
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
