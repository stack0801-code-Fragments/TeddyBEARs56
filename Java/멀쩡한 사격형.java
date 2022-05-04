class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        answer = (long) w * (long) h - (w + h - gcd(w,h));
        return answer;
    }
    public int gcd(int a, int b) {
        if(a%b == 0)
            return b;
        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(8, 12));
    }
}
// 재귀함수로 최대공약수 (종이가 클수록 함수호출이 늘어남) 한번에 구하는 식이 좋을듯
// 유클리드 호제법? 코드가 짧다
