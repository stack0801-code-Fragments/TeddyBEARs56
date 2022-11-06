import java.awt.*;
import java.util.Scanner;

class Solution
{
    public static int max;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;          // 길이

        for (int i = 1; i <= 10; i++) {
            max = 0;
            T = sc.nextInt();
            char[][] arr = new char[100][100];
            for (int j = 0; j < 100; j++)
                arr[j] = sc.next().toCharArray();
            for (int j = 0; j < 100; j++)
                for (int k = 0; k < 100; k++)
                    for (int l = 0; l < 100; l++)
                        BFS(j,arr,new Point(k,l));

            System.out.println("#" + T + " " + max);
        }
        sc.close();
    }


    public static void BFS(int length, char[][] arr, Point p){
        StringBuilder str = new StringBuilder();
        if(p.x + length <= 100 ){
            for (int i = 0; i < length; i++)
                str.append(arr[p.y][p.x + i]);
            if(str.toString().equals(str.reverse().toString()))
                if(max < str.length())
                    max = str.length();
        }
        str = new StringBuilder();
        if(p.y + length <= 100 ){
            for (int i = 0; i < length; i++)
                str.append(arr[p.y + i][p.x]);
            if(str.toString().equals(str.reverse().toString()))
                if(max < str.length())
                    max = str.length();
        }
    }
}