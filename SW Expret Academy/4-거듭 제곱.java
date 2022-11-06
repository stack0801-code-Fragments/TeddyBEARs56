import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        for (int i = 0; i < 10; i++) {
            T=sc.nextInt();
            int num = sc.nextInt(), pow = sc.nextInt();
            System.out.println("#" + T + " " + (long)Math.pow(num, pow));
        }
        sc.close();
    }
}