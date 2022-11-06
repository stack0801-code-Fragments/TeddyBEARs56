import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        int[] arr;
        int count;
        for(int i = 1; i <= 10 ; i++) {
            T=sc.nextInt();
            arr = new int[T];
            count = 0;
            for (int test_case = 1; test_case <= T; test_case++) { arr[test_case - 1] = sc.nextInt(); }
            for (int test_case = 1; test_case <= T; test_case++) {
                if (test_case >= 3 && T - 2 >= test_case) {
                    int left = Math.max(arr[test_case - 3], arr[test_case - 2]);
                    int right = Math.max(arr[test_case + 1], arr[test_case]);
                    if (left < arr[test_case - 1] && right < arr[test_case - 1]) count += arr[test_case - 1] - Math.max(left, right);
                }
            }
            System.out.println("#" +i+ " " + count);
        }
        sc.close();
    }
}