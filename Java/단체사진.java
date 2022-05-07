class Solution {
    String[] kakao_friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;

    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[8];
        search("", visited, n, data);
        return answer;
    }

    public void search( String str, boolean[] visited, int n, String[] data){
        if(str.length() == 8){      // 7로하면 더빠름 왜???? 근데 왜 가능해???? 씨발
            boolean check = true;
            int ac,distance;
            char option;
            for(String line : data) {
                ac = Math.abs(str.indexOf(line.charAt(0)) - str.indexOf(line.charAt(2)));
                option = line.charAt(3);
                distance = line.charAt(4) - 47;     //0 2
                if (option == '=') {
                    if (!(ac == distance)) {
                        check = false;
                        break;
                    }
                } else if (option == '<') {
                    if (!(ac < distance)) {
                        check = false;
                        break;
                    }
                } else if (option == '>') {
                    if (!(ac > distance)) {
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                answer++;
            }
            return;
        }
        for(int num = 0; num < kakao_friends.length ; num++){
            if(!visited[num]){
                visited[num] = true;
                search( str + kakao_friends[num], visited, n, data);
                visited[num] = false;
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
