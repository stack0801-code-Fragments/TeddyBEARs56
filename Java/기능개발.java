class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;   
        int days = 0;   
        int length = 0; // return할 answer의 길이를 동적으로 선언하기 위한 길이 변수 
        int max = 0;    // 순서대로 배열을 순회할 때 가장 오래 걸리는 날을 저장하는 변수
        for(int i=0; i < progresses.length; i++){   // 작업만큼 반복
            while(progresses[i] < 100){             // 진행도가 100가 될때 까지 반복
                progresses[i] += speeds[i];         // 작업의 속도만큼 증가
                days++;                             // 얼마나 걸리는지 계산
            }
            if(max < days){                         // 가장 오래걸리는 시간보다 오래 걸리면
                max = days;                         // 갱신 시켜주고 
                length++;                           // 배열 공간 한칸 추가
            }
            progresses[i] = max;                    // progresses배열을 재사용 ex) {5, 10, 10, 10, 20, 20}
            days = 0;                               // 걸리는 날 초기화
        }
        answer = new int[length];                   // 필요한 배열 동적으로 메모리 할당 ex) 3칸
        length = 0;                                 // answer 동적배열의 배열 위치를 나타내기 위해 재사용
        max = 0;                                    // 가장 오래 걸리는 작업 저장 변수로 사용
        for(int i=0; i < progresses.length; i++){   // 작업만큼 반복
            if(max < progresses[i]){                // max보다 큰 작업기간이 있으면
                max = progresses[i];                // 갱신 시켜주고
                answer[length] = 1;                 // answer 배열에 첫번째 부터 1로 초기화
                length++;                           // 다음 배열 가르기코
            }else if( max == progresses[i]){        // max와 같은 작업기간을 가지면
                answer[length-1]++;                 // 증가하기 전 answer 배열의 값을 증가시켜줌
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] progresses = { 95,90,99,99,80,99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(s.solution(progresses,speeds));
    }
}
