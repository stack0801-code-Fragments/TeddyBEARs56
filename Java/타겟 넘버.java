import java.util.*;

class Solution {
    int answer = 0;
    //boolean[] visited;
    public int solution(int[] numbers, int target)
    {
        DFS(numbers, 0, target , 0);
        //visited = new boolean[numbers.length];
        //if(check2(numbers,target) == target) answer++;
        //check(numbers, target);
        return answer;
    }
    public void DFS (int[]  numbers, int result, int target, int end){
        if(end < numbers.length) {
            DFS(numbers, result + numbers[end], target, end + 1);       // +
            DFS(numbers, result - numbers[end], target, end + 1);       // -
        }else{
            if(result == target)        // 끝까지 도달 했다면 목표수치와 결과를 비교
                answer++;               
            return;
        }
    }
//    매우 비효율적 삽질...
//    public void check(int[] numbers, int target){
//        int count1 = 0;
//        int count2 = 0;
//        for(int i = 0; i < visited.length; i++) {
//            System.out.println("c1 : " + count1 + " c2 : " + count2);
//            if(count1 == count2 && !visited[i]){
//                count1++;
//                visited[i] = true;
//                if(check2(numbers,target) == target) answer++;
//                check(numbers, target);
//                visited[i] = false;
//            }
//            count2++;
//        }
//        count1 = 0;
//        count2 = 0;
//    }
//
//    public int check2 (int[] numbers, int target ){
//        int result = 0;
//        for(int j = 0; j< visited.length; j++){
//            if (visited[j]) {
//                result += numbers[j];
//                System.out.print(" +" + numbers[j]);
//            }
//            else {
//                result -= numbers[j];
//                System.out.print(" -" + numbers[j]);
//            }
//        }
//        System.out.println(" = " + result);
//        check2222++;
//        return result;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {4, 1, 2, 1};
        System.out.println(s.solution(num,4));

    }
}