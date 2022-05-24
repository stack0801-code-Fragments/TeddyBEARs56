import java.util.Arrays;

class Solution {

    public String solution(int[] numbers) {
        String[] str_numbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++)
            str_numbers[i] = Integer.toString(numbers[i]);
        Arrays.sort(str_numbers, (o1, o2) ->( (o2 + o1).compareTo(o1 + o2)));
        return String.join("", str_numbers).charAt(0) == '0' ? "0" : String.join("", str_numbers);
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        Solution s = new Solution();
        System.out.println(s.solution(numbers));
    }
}