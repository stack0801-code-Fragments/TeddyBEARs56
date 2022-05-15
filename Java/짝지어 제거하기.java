import java.util.Stack;
class Solution {
    public int solution(String s)
    {
        Stack<Character> test = new Stack<Character>(); // Stack 구조로 순차적으로 처리
        for(char ch : s.toCharArray()){             // 문자열 s를 ch로 반복
            if(test.isEmpty()) test.push(ch);       // stack이 비어 있다면 ch 쌓기
            else{                                   // 그렇지 않다면
                if(test.peek() == ch) test.pop();   // 스텍의 맨위 값과 ch를 비교하여 같다면 스텍에서 pop
                else test.push(ch);                 // 그렇지 않다면 스텍 맨위로 push
            }
        }
        if(test.isEmpty()) return 1;        // 모두 짝지어진 경우 return 1
        else return 0;                      // 그렇지 않으면 return 0
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String data = "cdcd";
        System.out.println(s.solution(data));
    }
}