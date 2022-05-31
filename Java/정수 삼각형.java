
class Solution {
    int max = 0;
    public int solution(int[][] triangle) {
        for(int i = 0 ; i < triangle.length - 1; i++){
            triangle[i+1][0] += triangle[i][0];
            for(int j = 1; j <triangle[i].length; j++)
                if(triangle[i][j-1] < triangle[i][j])
                    triangle[i+1][j] += triangle[i][j];
                else
                    triangle[i+1][j] += triangle[i][j-1];
            triangle[i+1][triangle[i+1].length-1] += triangle[i][triangle[i].length-1];
        }
        for(int num : triangle[triangle.length-1])
            max = Math.max(max,num);
        return max;
    }

    public static void main(String[] args) {
        int[][] triangle = {
                    {7},
                   {3, 8},
                  {8, 1, 0},
                 {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        Solution s = new Solution();
        System.out.println(s.solution(triangle));
    }
}

//    public void DFS(int[][] triangle, int floor, int index, int sum){
//        if(floor == triangle.length){
//            if(max < sum) max = sum;
//            return;
//        }
//        DFS(triangle,floor + 1,index,sum + triangle[floor][index]);
//        DFS(triangle,floor + 1,index + 1,sum + triangle[floor][index]);
//    }