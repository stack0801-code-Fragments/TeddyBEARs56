class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int num = 1;
        for(int i=0 ; i<rows ; i++)
            for(int j=0 ; j<columns ; j++)
                map[i][j] = num++;
        for(int i = 0; i < queries.length; i++)
            answer[i] = shake(queries[i], map);
        return answer;
    }

    public int shake(int[] queries, int[][] map){
        int f_y = queries[0] - 1, f_x = queries[1] - 1, l_y = queries[2] - 1, l_x = queries[3] - 1;
        int buffer1 = map[f_y][f_x], min;
        min = buffer1;

        for(int i = f_y; i < l_y; i++){
            min = min_check(min, map[i + 1][f_x]);
            map[i][f_x] = map[i + 1][f_x];
        }
        for(int i = f_x; i < l_x; i++){
            min = min_check(min, map[l_y][i + 1]);
            map[l_y][i] = map[l_y][i + 1];
        }
        for(int i = l_y; i > f_y ; i--){
            min = min_check(min, map[i - 1][l_x]);
            map[i][l_x] = map[i - 1][l_x];
        }
        for(int i = l_x; i > f_x; i--){
            min = min_check(min, map[f_y][i - 1]);
            map[f_y][i] = map[f_y][i - 1];
        }
        map[f_y][f_x + 1] = buffer1;
        return min;
    }

    public int min_check(int min, int data){
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