import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T,tmp;
        Queue<Integer> queue = new LinkedList<>();
        Iterator<Integer> iter;
        for (int i = 0; i < 10; i++) {
            T=sc.nextInt();
            queue.clear();
            for (int j = 0; j < 8; j++)
                queue.add(sc.nextInt());
            loop1:
            while(true){
                for (int j = 1; j <= 5; j++) {
                    tmp = queue.remove() - j;
                    if(tmp < 1)
                        break loop1;
                    queue.add(tmp);
                }
            }
            iter = queue.iterator();
            System.out.print("#" + T + " ");
            while(iter.hasNext())
                System.out.print(iter.next() + " ");
            System.out.println(0);
        }
        sc.close();
    }
}