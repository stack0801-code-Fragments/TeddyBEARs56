import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, count;
        int[][] arr;
        boolean[] flag;
        for (int i = 1; i <= 10; i++) {
            T = sc.nextInt();
            count = 0;
            arr = new int[T][T];
            flag = new boolean[100];
            for(int y = 0; y < T; y++)
            {
                for (int x = 0; x < T; x++) {
                    arr[y][x] = sc.nextInt();
                    if(!flag[x] && arr[y][x] == 1){
                        flag[x] = true;
                    }else if(flag[x] && arr[y][x] == 2){
                        count++;
                        flag[x] = false;
                    }
                }
            }
            System.out.println("#" + i + " " + count);
        }
        sc.close();
    }
}