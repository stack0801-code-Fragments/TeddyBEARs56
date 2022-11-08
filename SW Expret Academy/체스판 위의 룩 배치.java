import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T, width, height;
        char[][] arr;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            arr = new char[8][8];
            boolean check = false;
            for (int i = 0; i <8; i++)
                arr[i] = sc.next().toCharArray();
            loop:
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    width = 0;
                    height = 0;
                    for (int k = 0; k < 8; k++) {
                        if (arr[i][k] == 'O')
                            width++;
                        if(arr[k][j] == 'O')
                            height++;
                    }
                    if(width != 1 || height != 1){
                        check = true;
                        break loop;
                    }
                }
            }
            System.out.print("#" + test_case + " ");
            if(check)
                System.out.println("no");
            else
                System.out.println("yes");
            sc.close();
        }
    }
}