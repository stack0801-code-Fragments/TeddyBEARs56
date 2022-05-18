import java.util.Objects;

class Solution {
    public String solution(String p) {
        if(Objects.equals(p, "")) return p;     //          1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        return test(p);
    }

    public String test(String p){
        int iter = subString(p);
        String u = p.substring(0, iter) , v = p.substring(iter);
        if(!check(u)){                          //        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            if(!v.equals("")) v = test(v);      //        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            return "(" + v + ")" + fix(u);      //        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.   //        4-3. ')'를 다시 붙입니다.    //        4-5. 생성된 문자열을 반환합니다.
        }
        if(!v.equals(""))  v = test(v);         //        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        return u + v;                           //        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
    }

    public int subString(String w){             //        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        int count = 0;
        for (int i = 0; i < w.length() ; i++){
            if(w.charAt(i) == '(')  count++;
            else count--;
            if(count == 0) return i + 1;
        }
        return -1;
    }

    public boolean check(String u){
        int count = 0;
        for (int i = 0; i < u.length() ; i++){
            if(u.charAt(i) == '(')  count++;
            else count--;
            if(count < 0) return false;
        }
        return true;
    }

    public String fix(String u){                //        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        StringBuilder str = new StringBuilder();
        for (int i = 1; i < u.length()-1 ; i++){
            if(u.charAt(i) == '(') str.append(")");
            else str.append("(");
        }
        return str.toString();
    }


    public static void main(String[] args) {
        String p = "()))((()";
        Solution s = new Solution();
        System.out.println(s.solution(p));
    }
}