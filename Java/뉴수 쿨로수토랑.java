import java.util.ArrayList;

class Solution {
    public void build(ArrayList<String> list, String str){
        char num1, num2;
        for (int i = 0; i < str.length() - 1; i++) {
            num1 = str.charAt(i);
            num2 = str.charAt(i + 1);
            if (Character.isLetter(num1) && Character.isLetter(num2))
                list.add(num1 + "" + num2);
        }
    }
    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        int intersection = 0, union = 0;
        build(list1, str1.toUpperCase());
        build(list2, str2.toUpperCase());
        union += list1.size() + list2.size();
        for(String str : list1){
            if(list2.contains(str)){
                list2.remove(str);
                intersection++;
            }
        }
        union -= intersection;
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