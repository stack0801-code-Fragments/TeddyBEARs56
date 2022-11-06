import java.awt.*;
import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int X, Y;
        int T = sc.nextInt();
        for (int k = 1; k <= T; k++) {
            Y = sc.nextInt();
            X = sc.nextInt();

            String[] arr = new String[Y];
            Point pt = new Point();

            for (int i = 0; i < Y; i++)
                arr[i] = sc.next();

            Loop1:
            for (int arr_y = 0; arr_y < Y; arr_y++) {
                for (int arr_x = X - 1; arr_x > 0; arr_x--) {
                    pt.x = arr_x;
                    pt.y = arr_y;
                    if (Character.getNumericValue(arr[arr_y].toCharArray()[arr_x]) == 1) {
                        break Loop1;
                    }
                }
            }

            int num = 0;
            int sum = 0;
            int left = 0, right = 0;
            pt.x -= 55;
            for (int i = 0; i < 8; i++) {
                String str = arr[pt.y].substring(pt.x, pt.x + 7);
                if ("0001101".equals(str)) num = 0;
                 else if ("0011001".equals(str)) num = 1;
                 else if ("0010011".equals(str)) num = 2;
                 else if ("0111101".equals(str)) num = 3;
                 else if ("0100011".equals(str)) num = 4;
                 else if ("0110001".equals(str)) num = 5;
                 else if ("0101111".equals(str)) num = 6;
                 else if ("0111011".equals(str)) num = 7;
                 else if ("0110111".equals(str)) num = 8;
                 else if ("0001011".equals(str)) num = 9;
                pt.x += 7;
                sum += num;
                if (i % 2 == 0)
                    left += num;
                else
                    right += num;
            }
            if((left * 3 + right) % 10 == 0)
                System.out.println("#"+ k + " " +sum);
            else
                System.out.println("#"+ k + " 0");
        }
        sc.close();
    }
}