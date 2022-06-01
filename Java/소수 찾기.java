import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean[] visited;
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        DFS(numbers, 0,"");
        return answer;
    }

    public void DFS(String numbers, int count, String str){
        if(count == numbers.length()) return;
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]) {
                visited[i] = true;
                if(primeNum(Integer.parseInt(str + numbers.charAt(i)))) answer++;
                DFS(numbers, count + 1, str + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    public boolean primeNum(int number){
        if(set.contains(number)) return false;
        else {
            set.add(number);
            if(number == 0) return false;
            else if (number == 1) return false;
            else if (number == 2) return true;
            else
                for (int i = 2; i * i <= number; i++) 
                    if (number % i == 0) return false;
                return true;
        }
    }
}