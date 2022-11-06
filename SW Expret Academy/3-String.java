import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T, count, index;
        String[] str = new String[2];

        for (int i = 0; i < 10; i++) {
            T=sc.nextInt();
            str[0] = sc.next();
            str[1] = sc.next();
            count = 0;
            while(true){
                index = str[1].indexOf(str[0]);
                if(index > -1){
                    char[] ch = str[1].toCharArray();
                    for (int j = 0; j < str[0].length(); j++)
                        ch[index + j] = '#';
                    count++;
                    str[1] = String.valueOf(ch);
                }
                else break;
            }
            System.out.println("#" + T + " " + count);
        }
        sc.close();
    }
}