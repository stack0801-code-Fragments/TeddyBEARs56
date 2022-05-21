class Solution {
    int[] rows1 = {0,1,0,-1}, cols1 = {-1,0,1,0};
    int[] rows2 = {1,1,-1,-1}, cols2 = {-1,1,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int count = 0;
        int check = 1;
        for(String[] strings : places){
            for(int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (strings[i].charAt(j) == 'P')
                        if (!BFS(strings, i, j))
                            check = 0;
                    if (check == 0) break;
                }
                if (check == 0) break;
            }
            answer[count++] = check;
            check = 1;
        }
        return answer;
    }
        public boolean BFS(String[] place, int row, int col) {
            int r, c;
            for(int i = 0; i<4; i++){
                r = row + rows1[i];
                c = col + cols1[i];
                if( r >= 0 && r < 5 && c >= 0 && c < 5) {
                    if (place[r].charAt(c) == 'P')
                        return false;
                    else if (place[r].charAt(c) == 'O') {
                        r += rows1[i];
                        c += cols1[i];
                        if (r >= 0 && r < 5 && c >= 0 && c < 5)
                            if (place[r].charAt(c) == 'P')
                                return false;
                    }
                }
                r = row + rows2[i];
                c = col + cols2[i];
                if( r >= 0 && r < 5 && c >= 0 && c < 5)
                    if (place[r].charAt(c) == 'P')
                        if(!(place[row].charAt(c) == 'X' && place[r].charAt(col) == 'X'))
                            return false;
            }
            return true;
        }

        public static void main(String[] args) {
            String[][] places = {
                    {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                    {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                    {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                    {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                    {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
            };
            Solution s = new Solution();
            for(int num : s.solution(places)){
                System.out.println(num);
            }
        }
    }