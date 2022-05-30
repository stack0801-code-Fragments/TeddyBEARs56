import java.util.Arrays;

class Solution {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++)
            if(phone_book[i].length() <= phone_book[i+1].length() && phone_book[i+1].contains(phone_book[i]))
                return false;
        return true;
    }
}