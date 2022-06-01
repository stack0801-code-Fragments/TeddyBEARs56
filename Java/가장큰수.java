import java.util.Arrays;

class Solution {

    public String solution(int[] numbers) {
        String[] str_numbers = new String[numbers.length];      // 동적 할당
        for(int i = 0; i < numbers.length; i++)                 // String 변환
            str_numbers[i] = Integer.toString(numbers[i]);
        Arrays.sort(str_numbers, (o1, o2) -> ( (o2 + o1).compareTo(o1 + o2)));   // 내림차순으로 정렬 메커니즘은 바로 인접한 두수를 2가지의 조합을 만들어 
        return String.join("", str_numbers).charAt(0) == '0' ? "0" : String.join("", str_numbers);  // 맨앞의 수가 0이면 "0"라톤 (11번) 
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        Solution s = new Solution();
        System.out.println(s.solution(numbers));
    }
}