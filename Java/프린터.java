import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int[] priorities, int location) {       // 많이 복잡한 느낌이 있다.... 보기에만 편한 풀이
        int answer = 0;
        Queue<Integer> location_queue = new LinkedList<>();     // 작업들어온 순서 queue
        Queue<Integer> priorities_queue = new LinkedList<>();  // 작업 우선순위  queue
        for(int i = 0; i < priorities.length; i++){             // 초기화
            location_queue.add(i);
            priorities_queue.add(priorities[i]);
        }
        ArrayList<Integer> sorted_priorities = new ArrayList<>(priorities_queue);; // 작업 우선순위 복사
        sorted_priorities.sort(Comparator.reverseOrder());                          // 작업 우선순위 내림차순 sorting

        for(int priority : sorted_priorities){      // 작업수 만큼
            answer++;                               // print 횟수
            for (int j = 0; j < priorities_queue.size(); j++) {         // queue 길이만큼 반복
                if (priorities_queue.peek() != priority) {              // 우선순위가 가장 높지 않다면
                    location_queue.add(location_queue.poll());          // 맨뒤로
                    priorities_queue.add(priorities_queue.poll());      // 맨뒤로 2
                }
                else {                                                  // 우선순위가 가장 높다면
                    if(location_queue.peek() == location)               // 그리고 찾고자 하는 작업이라면
                        return answer;                                  // 출력 순서를 출력
                    location_queue.remove();                            // 맨앞 삭제
                    priorities_queue.remove();                          // 맨앞 삭제 2
                    break;                                              // 재검색을 위한 반복문 탈출
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        Solution s = new Solution();
        System.out.println(s.solution(priorities, location));
    }
}