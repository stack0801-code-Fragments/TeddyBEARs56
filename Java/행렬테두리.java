class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        for(int i = 1; i <= rows; i++)
            for(int j = 1; j <= columns; j++)
                map[i-1][j-1] = (i-1) * rows + j;
        for(int i = 0; i < queries.length; i++){
            answer[i] = shake(rows, columns, queries[i], map);

            for(int k = 0; k < rows; k++){
                for(int j = 0; j < columns; j++)
                    System.out.print("      " + map[k][j]);
                System.out.println();
            }
        }
        return answer;
    }

    public int shake(int rows, int columns, int[] queries, int[][] map){
        int min = rows * columns;
        int f_y = queries[0] - 1, f_x = queries[1] - 1, l_y = queries[2] - 1, l_x = queries[3] - 1;
        int buffer1 = map[f_y][f_x], buffer2;
        for(int x = f_x + 1; x < l_x; x++){
            buffer2 = map[f_y][x];
            min = min_check(min, buffer2);
            map[f_y][x] = buffer1;
            buffer1 = buffer2;
        }
        for(int y = f_y; y < l_y; y++){
            buffer2 = map[y][l_x];
            min = min_check(min, buffer2);
            map[y][l_x] = buffer1;
            buffer1 = buffer2;
        }
        for(int x = l_x; x > f_x; x--){
            buffer2 = map[l_y][x];
            min = min_check(min, buffer2);
            map[l_y][x] = buffer1;
            buffer1 = buffer2;
        }
        for(int y = l_y; y >= f_y; y--){
            buffer2 = map[y][f_x];
            min = min_check(min, buffer2);
            map[y][f_x] = buffer1;
            buffer1 = buffer2;
        }
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
        int[] result = s.solution(rows,columns,queries);
    }
}