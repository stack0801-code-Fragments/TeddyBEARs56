import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2);                     // {{
        s = s.substring(0, s.length() - 2);     // }} 제거
        String[] strings = s.split("},\\{");    // },{ 로 분활
        Arrays.sort(strings, (o1,o2)->(o1.length()-o2.length()));   // 화살표 함수가 있더라... 
//        Arrays.sort(strings, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length() - s2.length();
//            }
//        });

        for(String str : strings){              // 자른 str을
            String[] numbers = str.split(",");  // 다시 , 로 해서 자르고
            for(String number : numbers){       // 하나씩 뽑아서
                int num = Integer.parseInt(number); // int형식으로 변환후
                if(!answer.contains(num))       // arraylist 에 없다면 최초로 저장
                    answer.add(num);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();      // int[]로 변형 여기도 화살표 함수
    }
    public static void main(String[] args) {
        String expression = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(expression)));
    }
}