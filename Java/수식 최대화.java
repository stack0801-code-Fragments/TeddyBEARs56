import java.util.ArrayList;

class Solution {
    long max = 0;
    //char[] item = {'*','+','-'};
    //boolean[] check = new boolean[3];
    char[][] item = {{'*','+','-'}, {'*','-','+'}, {'+','*','-'}, {'+','-','*'}, {'-','*','+'}, {'-','+','*'}};     // 하드코딩 만세! 시간 비교해봤는데 
    ArrayList<Long> numbers = new ArrayList<>();
    ArrayList<Character> operators = new ArrayList<>();
    
    public long solution(String expression) {
        StringBuilder number = new StringBuilder();
        expression = expression + " ";
        for(char ch : expression.toCharArray()){
            if(Character.isDigit(ch)){
                number.append(ch);
            }else{
                numbers.add((long)Integer.parseInt(number.toString()));
                operators.add(ch);
                number = new StringBuilder();
            }
        }
        for(char[] chars : item){
            CAL(chars);
        }
        //DFS(new char[3], 0);
        return max;
    }

    public void CAL(char[] items){
        long answer = 0;
        ArrayList<Long> new_numbers = new ArrayList<>(numbers);
        ArrayList<Character> new_operators = new ArrayList<>(operators);
        for(char item : items){
            int index = new_operators.indexOf(item);
            while(index > -1) {
                if(item == '*')
                    answer = new_numbers.get(index) * new_numbers.get(index + 1);
                else if(item == '+')
                    answer = new_numbers.get(index) + new_numbers.get(index + 1);
                else
                    answer = new_numbers.get(index) - new_numbers.get(index + 1);
                new_operators.remove(index);
                new_numbers.remove(index);
                new_numbers.remove(index);
                new_numbers.add(index, answer);
                index = new_operators.indexOf(item);
            }
        }
        answer = Math.abs(answer);
        if(max < answer)
            max = answer;
    }

//    public void DFS(char[] new_item, int index){
//        if(index == 3){
//            CAL(new_item);
//        }
//        for(int i = 0; i < 3; i++){
//            if(!check[i]){
//                check[i] = true;
//                new_item[index] = item[i];
//                DFS(new_item, index + 1);
//                check[i] = false;
//            }
//        }
//    }

    public static void main(String[] args) {
        String expression = "50*6-3*2";
        Solution s = new Solution();
        System.out.println(s.solution(expression));
    }
}