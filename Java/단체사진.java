class Solution {
    String[] kakao_friends = {"A", "C", "F", "J", "M", "N", "R", "T"};      // 카카오 프렌즈
    int answer = 0;     // 결과

    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[8];     // 방분 여부 배열
        search("", visited, n, data);           // 검색 재귀함수
        return answer;
    }

    public void search( String str, boolean[] visited, int n, String[] data){
        if(str.length() == 8){      // 잘 이해가 안가지만 7을 넣어도 답은 나오고 오히려 횟수가 줄어 성능이 좋다 : 마지막 길이까지 도달 했을 경우
            boolean check = true;   // 조건이 맞는지 확인하는 함수
            int ac,distance;        // ac : 계산값, distance : 두 프렌즈간 거리
            char option;            // 거리 조건
            for(String line : data) {   // 조건 만큼 반복
                ac = Math.abs(str.indexOf(line.charAt(0)) - str.indexOf(line.charAt(2)));   // 절대값(두 프렌즈간 거리)
                option = line.charAt(3);            // 조건 = < >
                distance = line.charAt(4) - 47;     // 프렌즈간 거리 ex) 1번째 0, 2번째 2
                if (option == '=') {        //조건 =
                    if (!(ac == distance)) {//조건과 상이 하면 false, 그 뒤는 무의미 하기 때문에 break
                        check = false;
                        break;
                    }
                } else if (option == '<') { //조건 < 
                    if (!(ac < distance)) { 
                        check = false;
                        break;
                    }
                } else if (option == '>') { //조건 < 
                    if (!(ac > distance)) { 
                        check = false;
                        break;
                    }
                }
            }
            if(check){      // 모든 조건을 통과하면 비로소 카운트
                answer++;
            }
            return;
        }
        for(int num = 0; num < kakao_friends.length ; num++){   //프렌즈의 수만큼 반복
            if(!visited[num]){          // 방분하지 않았다면
                visited[num] = true;    // 방문했다고 알리고 재귀함수 진입
                search( str + kakao_friends[num], visited, n, data);
                visited[num] = false;   // 재귀함수가 끝나면 나간다고 알림
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(s.solution(n,data));
    }
}
