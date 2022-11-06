import java.awt.*;
import java.util.Scanner;

class Solution
{
    public static int count;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int length;          // 길이

        for (int i = 1; i <= 10; i++) {
            count = 0;
            length = sc.nextInt();
            char[][] arr = new char[8][8];
            for (int j = 0; j < 8; j++)
                arr[j] = sc.next().toCharArray();
            for (int j = 0; j < 8; j++)
                for (int k = 0; k < 8; k++)
                    BFS(length,arr,new Point(j,k));

            System.out.println("#" + i + " " + count);
        }
        sc.close();
    }


    public static void BFS(int length, char[][] arr, Point p){
        StringBuilder str = new StringBuilder();
        if(p.x + length <= 8 ){
            for (int i = 0; i < length; i++)
                str.append(arr[p.y][p.x + i]);
            if(str.toString().equals(str.reverse().toString()))
                count++;
        }
        str = new StringBuilder();
        if(p.y + length <= 8 ){
            for (int i = 0; i < length; i++)
                str.append(arr[p.y + i][p.x]);
            if(str.toString().equals(str.reverse().toString()))
                count++;
        }
    }
}