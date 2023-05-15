import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int[][] map = new int[100][100];
            ArrayList<Integer> arraylist = new ArrayList<>();

            System.out.print("#" + sc.next() + " ");

            for(int x = 0; x < 100; x++){
                map[0][x] = sc.nextInt();
                if(map[0][x] == 1)
                    arraylist.add(x);
            }

            for (int y = 1; y < 100; y++)
                for(int x = 0; x < 100; x++)
                    map[y][x] = sc.nextInt();


            int min_length = 10000;
            int result = -1;
            for (int i = 0; i < arraylist.size(); i++) {
                int length = 0;
                int point = i;
                for (int y = 99; y >= 0; y--) {
                    if (point == 0) {     // 좌측 맨 끝
                        // 우측 검사
                        if (map[y][arraylist.get(point) + 1] == 1) {
                            length += arraylist.get(point + 1) - arraylist.get(point);
                            point++;
                        }
                    } else if (point == arraylist.size() - 1) { // 우측 맨 끝
                        // 좌측 검사
                        if (map[y][arraylist.get(point) - 1] == 1) {
                            length += arraylist.get(point) - arraylist.get(point - 1);
                            point--;
                        }
                    } else {
                        // 우측 검사
                        if (map[y][arraylist.get(point) + 1] == 1) {
                            length += arraylist.get(point + 1) - arraylist.get(point);
                            point++;
                            continue;
                        } // 좌측 검사
                        if (map[y][arraylist.get(point) - 1] == 1) {
                            length += arraylist.get(point) - arraylist.get(point - 1);
                            point--;
                        }
                    }
                }
                if(min_length>length) {
                    min_length = length;
                    result = point;
                }
            }
            System.out.println(arraylist.get(result));
        }
    }

}