import java.util.Stack;
class Solution {
    public int solution(String int[])
    {
        Stack<Character> test = new Stack<Character>();
        for(char ch : s.toCharArray()){
            if(test.isEmpty()) test.push(ch);
            else{
                if(test.peek() == ch) test.pop();
                else test.push(ch);
            }
        }
        if(test.isEmpty()) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {1, 1, 1, 1, 1}
        System.out.println(s.solution(num));
    }
}