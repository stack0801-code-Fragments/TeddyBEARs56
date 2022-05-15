class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];   // 이차원 배열에 값 채우기
        int num = 1;                            // 이거 복잡하게 만들었더니 앞에 2개빼고 실패
        for(int i=0 ; i<rows ; i++)
            for(int j=0 ; j<columns ; j++)
                map[i][j] = num++;
        for(int i = 0; i < queries.length; i++) // 쿼리만큼 실행
            answer[i] = shake(queries[i], map);
        return answer;
    }

    public int shake(int[] queries, int[][] map){
        int f_y = queries[0] - 1, f_x = queries[1] - 1, // 시작점 x,y
            l_y = queries[2] - 1, l_x = queries[3] - 1; // 끝점 x,y
        int buffer1 = map[f_y][f_x], min;   // 시작지점 값 저장 및 가장 작은수 
        min = buffer1;                      // 시작지점 값을 작은수로 시작
                                            // Reverse Tracking
        for(int i = f_y; i < l_y; i++){             // 시작점 x,y 에서 끝점 y까지
            min = min_check(min, map[i + 1][f_x]);
            map[i][f_x] = map[i + 1][f_x];
        }
        for(int i = f_x; i < l_x; i++){             // 시작점 x 끝점 y에서 끝점 x,y까지
            min = min_check(min, map[l_y][i + 1]);
            map[l_y][i] = map[l_y][i + 1];
        }
        for(int i = l_y; i > f_y ; i--){            // 끝점 x,y 에서 끝점 x 시작점 y까지
            min = min_check(min, map[i - 1][l_x]);
            map[i][l_x] = map[i - 1][l_x];
        }
        for(int i = l_x; i > f_x; i--){             // 끝점 x 시작점 y에서 시작점 x,y까지
            min = min_check(min, map[f_y][i - 1]);
            map[f_y][i] = map[f_y][i - 1];
        }                                           // 뒤에 있는 수를 앞으로 덮어 씌우는 식
        map[f_y][f_x + 1] = buffer1;                // 맨 마지막 방문하는 좌표를 시작점의 값으로
        return min;
    }

    public int min_check(int min, int data){    // 작은값
        if(min >= data)
            return data;
        return min;
    }

    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;
        int[][] queries = {{1,1,2,2}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}};
        Solution s = new Solution();
        for(int i : s.solution(rows,columns,queries)) System.out.println(i);
    }
}