import java.util.ArrayList;

class Solution {
    public void build(ArrayList<String> list, String str){
        char num1, num2;
        for (int i = 0; i < str.length() - 1; i++) {
            num1 = str.charAt(i);
            num2 = str.charAt(i + 1);
            if (Character.isLetter(num1) && Character.isLetter(num2))   // isLetter 문자만 취급(기호, 특수문자, 숫자 x)
                list.add(num1 + "" + num2);
        }
    }

    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>(), list2 = new ArrayList<>(); // str1 , str2 담을 공간
        int intersection = 0, union;
        build(list1, str1.toUpperCase());   // toUpperCase 대문자로 통일
        build(list2, str2.toUpperCase());   // 두글자씩 자르기
        union = list1.size() + list2.size();// 두 배열의 합을 구한후
        for(String str : list1){        // str1 기준으로 str2에 존재하면 str2에서 삭제 시킨다
            if(list2.contains(str)){
                list2.remove(str);
                intersection++;         // 교집합 추가
            }
        }
        union -= intersection;              // 교집합 되는 수를 뺀다
        if(intersection == 0 && union == 0)
            return 65536;
        else
            return (int)(((double) intersection / (double) union) * 65536);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("aa1+aa2"	,"AAAA12"));
    }
}

//        ArrayList<String> strings = new ArrayList<>();
//        strings.add(str1.toUpperCase());
//        strings.add(str2.toUpperCase());
//        for(String str : strings){
//            for(int i = 0; i < str.length() - 1; i++){
//                num1 = str.charAt(i);
//                num2 = str.charAt(i + 1);
//                if (Character.isLetter(num1) && Character.isLetter(num2)){
//                    if(strings.indexOf(str) == 0){
//                        list1.add(num1 + "" + num2);
//                    }
//                    else{
//                        list2.add(num1 + "" + num2);
//                    }
//                }
//            }
//        }