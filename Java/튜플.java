import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2);
        s = s.substring(0, s.length() - 2);
        String[] strings = s.split("},\\{");
        Arrays.sort(strings, (o1,o2)->(o1.length()-o2.length()));
//        Arrays.sort(strings, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length() - s2.length();
//            }
//        });

        for(String str : strings){
            String[] numbers = str.split(",");
            for(String number : numbers){
                int num = Integer.parseInt(number);
                if(!answer.contains(num))
                    answer.add(num);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        String expression = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(expression)));
    }
}