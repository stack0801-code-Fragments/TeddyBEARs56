class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int days = 0;
        int length = 0;
        int max = 0;
        for(int i=0; i < progresses.length; i++){
            while(progresses[i] < 100){
                progresses[i] += speeds[i];
                days++;
            }
            if(max < days){
                max = days;
                length++;
            }
            progresses[i] = max;
            days = 0;
        }
        answer = new int[length];
        length = 0;
        max = 0;
        for(int i=0; i < progresses.length; i++){
            if(max < progresses[i]){
                max = progresses[i];
                answer[length] = 1;
                length++;
            }else if( max == progresses[i]){
                answer[length-1]++;
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
