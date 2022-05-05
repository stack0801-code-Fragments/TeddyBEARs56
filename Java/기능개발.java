class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] check = new int[progresses.length];
        int count = 0;
        int count1 = 0;
        int max = 0;
        for(int i=0; i < progresses.length; i++){
            while(progresses[i] < 100){
                progresses[i] += speeds[i];
                count++;
            }
            if(max < count){
                max = count;
                count1++;
            }
            check[i] = max;
            count = 0;
        }
        answer = new int[count1];
        count1 = 0;
        max = 0;
        for(int i=0; i < check.length; i++){
            if(max < check[i]){
                max = check[i];
                answer[count1] = 1;
                count1++;
            }else if( max == check[i]){
                answer[count1-1]++;
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
