class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int[] numbers, int target)
    {
        visited = new boolean[numbers.length];
        if(check2(numbers,target) == target) answer++;
        check(numbers, target);
        return answer;
    }

    public void check(int[] numbers, int target){
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < visited.length; i++) {
            if(count1 == count2 && !visited[i]){
                count1++;
                visited[i] = true;
                if(check2(numbers,target) == target) answer++;
                check(numbers, target);
                visited[i] = false;
            }
            count2++;
        }
        count1 = 0;
        count2 = 0;
    }

    public int check2 (int[] numbers, int target ){
        int result = 0;
        for(int j = 0; j< visited.length; j++){
            if (visited[j]) result += numbers[j];
            else result -= numbers[j];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {1, 1, 1, 1, 1};
        System.out.println(s.solution(num,3));
    }
}