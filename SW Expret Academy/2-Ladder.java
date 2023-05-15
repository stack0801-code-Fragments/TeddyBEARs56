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
            Boolean flag = false;
            int point = -1;

            System.out.print("#" + sc.next() + " ");

            for(int x = 0; x < 100; x++){
                map[0][x] = sc.nextInt();
                if(map[0][x] == 1)
                    arraylist.add(x);
            }

            for (int y = 1; y < 99; y++)
                for(int x = 0; x < 100; x++)
                    map[y][x] = sc.nextInt();

            for(int x = 0; x < 100; x++){
                map[99][x] = sc.nextInt();
                if(map[99][x] == 2)
                    point = arraylist.indexOf(x);
            }

            for (int y = 99; y >= 0; y--) {
                if(point == 0){     // 좌측 맨 끝
                    // 우측 검사
                    if(map[y][arraylist.get(point) + 1] == 1){
                        point ++;
                    }
                }
                else if(point == arraylist.size() - 1){ // 우측 맨 끝
                    // 좌측 검사
                    if(map[y][arraylist.get(point) - 1] == 1){
                        point--;
                    }
                }
                else{
                    // 좌측 우측 검사
                    if(map[y][arraylist.get(point) + 1] == 1){
                        point++;
                        continue;
                    }
                    if(map[y][arraylist.get(point) - 1] == 1){
                        point--;
                    }
                }
            }
            System.out.println(arraylist.get(point));
        }
    }

}