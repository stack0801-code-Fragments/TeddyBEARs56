import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int len, cmd_cnt, index, cmd_len;
        String cmd;
        ArrayList<Integer> code = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            code.clear();
            len = sc.nextInt();
            for (int j = 0; j < len; j++)
                code.add(sc.nextInt());
            cmd_cnt = sc.nextInt();
            for (int j = 0; j < cmd_cnt; j++) {
                cmd = sc.next();
                // 3번
                if(cmd.equals("A")){
                    cmd_len = sc.nextInt();
                    for (int k = 0; k < cmd_len; k++)
                        code.add(sc.nextInt());
                }else{
                    index = sc.nextInt();
                    cmd_len = sc.nextInt();
                    // 1번
                    if(cmd.equals("I"))
                        for (int k = 0; k < cmd_len; k++)
                            code.add(index++, sc.nextInt());
                    // 2번
                    else if(cmd.equals("D")){
                        for (int k = 0; k < cmd_len; k++)
                            code.remove(index);
                    }
                }
            }
            System.out.print("#" + i + " ");
            for (int j = 0; j < 10; j++)
                System.out.print(code.get(j) + " ");
            System.out.println();
        }
    }
}