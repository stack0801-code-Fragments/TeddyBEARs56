import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();     // 조합과 키
    int max_num = 0;                                    // 가장 많은 주문
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();       // ArrayList
        String[] new_orders = new String[orders.length];    // 입력받은 orders를 sorting
        for(int i = 0; i < orders.length; i++){
            char[] sol = orders[i].toCharArray();   // 캐릭터 배열로 변환해서
            Arrays.sort(sol);                       // sort(정렬)하고
            new_orders[i]  = new String(sol);       // new_orders에 집어 넣음
        }
        for (int k : course) {                  // 조합의 수만큼
            for (String order : new_orders) {   // String 하나씩 DFS 실행
                DFS(order, k, "", 0);
            }
            for (String str : map.keySet()) {   // map의 키값만큼 반복
                if (max_num == map.get(str)) {  
                    answer.add(str);            // map을 기록할 때 가장 큰 횟수와 같은 조합을 answer에 추가
                }
            }
            map = new HashMap<>();      // 다음 문자열 에대한 새로운 map 생성
            max_num = 0;                // 횟수 초기화
        }
        Collections.sort(answer);   // sort(정렬)
        return answer.toArray(String[]::new);       // string으로 변환
    }

    public void DFS(String orders, int course, String answer, int num) {
        if(orders.length() < course) return;    // 주문수 보다 조합의수가 더 많으면 return
        if(answer.length() == course){      // 만들어진 문자열의 길이가 조합의 길이가 되면
            if(map.get(answer) == null)     // map에 문자열이 존재하지 않다면
                map.put(answer, 1);         // 문자열(key)와 1(value)를 추가
            else{                       
                num = map.get(answer);      
                map.replace(answer,num + 1);        // 존재한다면 value ++    
                if(max_num < num) max_num = num;    // 가장 많은 주문 횟수
            }
            return;
        }
        for(int i = num; i < orders.length(); i++)
            DFS(orders, course, answer + orders.charAt(i), i + 1);  // 재귀 함수
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};

        String[] result = s.solution(orders,course);
        for(String str : result){
            System.out.println(str);
        }
    }
}