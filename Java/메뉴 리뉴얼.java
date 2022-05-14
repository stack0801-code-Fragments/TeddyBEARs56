import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    int max_num = 0;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        String[] new_orders = new String[orders.length];
        for(int i = 0; i < orders.length; i++){
            char[] sol = orders[i].toCharArray();
            Arrays.sort(sol);
            new_orders[i]  = new String(sol);
        }
        for (int k : course) {
            for (String order : new_orders) {
                DFS(order, k, "", 0);
            }
            for (String str : map.keySet()) {
                if (max_num == map.get(str)) {
                    answer.add(str);
                }
            }
            map = new HashMap<>();
            max_num = 0;
        }
        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }

    public void DFS(String orders, int course, String answer, int num) {
        if(orders.length() < course)
            return;
        if(answer.length() == course){
            if(map.get(answer) == null){
                map.put(answer, 1);
            }else{
                map.replace(answer,map.get(answer) + 1);
                num = map.get(answer);
                if(max_num < num){
                    max_num = num;
                }
            }
            return;
        }
        for(int i = num; i < orders.length(); i++){
            DFS(orders, course, answer + orders.charAt(i), i + 1);
        }
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