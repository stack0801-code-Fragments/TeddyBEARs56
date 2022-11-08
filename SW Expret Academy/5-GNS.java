import java.util.*;

class Solution
{

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, len;
        HashMap<String, Integer> hashmap = new HashMap<>();
        String str;
        String[] arr = new String[] {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
     	T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            for(int i = 0; i<10; i++)
           	 	hashmap.put(arr[i], 0);
            System.out.println(sc.next());
            len = sc.nextInt();
            for(int i = 0; i < len; i++){
                str = sc.next();
                hashmap.put(str, hashmap.get(str) + 1);
            }
            for(int i = 0; i < 10; i++)
                for(int j = 0; j < hashmap.get(arr[i]); j++)
                    System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}