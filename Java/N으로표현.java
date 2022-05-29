class Solution {

    int answer = 10;
    public int solution(int N, int number) {
        DFS(N, number, 0,0);
        if(answer ==  10) answer = -1;
        return answer;
    }

    public void DFS(int N, int number, int iterator, int cal){
        if(iterator == 9)
            return ;
        if(cal == number){
            if(answer > iterator) answer = iterator;
            return ;
        }
        int tempN = N;
        for (int i = iterator; i < 8; i++) {
            if(answer <= i) break;
            DFS(N, number, i + 1, cal + tempN);
            DFS(N, number, i + 1, cal - tempN);
            DFS(N, number, i + 1, cal / tempN);
            DFS(N, number, i + 1, cal * tempN);
            tempN = tempN * 10 + N;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5,12));
    }
}