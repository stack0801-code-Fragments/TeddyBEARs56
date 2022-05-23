import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        boolean[][][] gird_check = new boolean[grid.length][grid[0].length()][4];   // row col 동서남북     3차원 배열 할당
        for (int i = 0; i < gird_check.length; i++)
            for(int j = 0; j < gird_check[0].length; j++)
                for(int k = 0; k < gird_check[0][0].length; k++)
                    if(!gird_check[i][j][k])
                        answer.add(check(grid, gird_check, i, j, k));        // 동 : 0 , 서 : 1, 남 : 2, 북 : 3     순회길이를 저장
        int[] result = Arrays.sort(answer.stream().mapToInt(i -> i).toArray());     // Arrays.sort(Arraylist to int[]) 
        return result;
    }
    public int check(String[] grid, boolean[][][] gird_check, int col, int row, int visit){
        int check = 0;  // 한 사이클 계산
        while(!gird_check[col][row][visit]){
            gird_check[col][row][visit] = true;     // 방문기록
            check++;    // 접근 할 때 ++
            if(grid[col].charAt(row) == 'R')        // 오른쪽이면 
                if (visit == 0)                 visit = 2;  // 접근 방향에 따라 이동 방향 설정
                else if(visit == 1)             visit = 3;
                else if(visit == 2)             visit = 1;
                else                            visit = 0;
            else if(grid[col].charAt(row) == 'L')   // 왼쪽이면
                if (visit == 0)                 visit = 3;  // 접근 방향에 따라 이동 방향 설정
                else if(visit == 1)             visit = 2;
                else if(visit == 2)             visit = 0;
                else                            visit = 1;
            if (visit == 0)                         // 이동 방향에 따라
                if(row + 1 == grid[0].length()) row = 0;    //범위를 벗어 나지 않도록 좌표 수정
                else                            row++;
            else if(visit == 1)
                if(row - 1 == -1)               row = grid[0].length() - 1;
                else                            row--;
            else if(visit == 2)
                if(col + 1 == grid.length)      col = 0;
                else                            col++;
            else
                if(col - 1 == -1)               col = grid.length - 1;
                else                            col--;
        }
        return check;   // 다시 제자리로 돌아온다면 그동안 순회한 길이 return
    }

    public static void main(String[] args) {
        String grid[] = {"SL","LR"};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(grid)));
    }
}