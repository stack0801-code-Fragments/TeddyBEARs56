import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;

        for(int k = 0; k < 10; k++) {
            T=sc.nextInt();
            int[] arr = new int[202];
            for (int test_case = 0; test_case < 10000; test_case++) {
                int num = sc.nextInt();
                arr[test_case % 100] += num;
                arr[test_case / 100 + 100] += num;
                if (test_case % 100 - test_case / 100 == 0)
                    arr[200] += num;

                if (test_case % 100 + test_case / 100 == 99)
                    arr[201] += num;

            }
            System.out.println("#" + T + " " + Arrays.stream(arr).max().getAsInt());
        }
        sc.close();
    }
}