class Solution {    
    public long solution(int w, int h) {    
        long answer = 0;
        answer = (long) w * (long) h - (w + h - gcd(w,h));      
        // 사각형의 면의 최대공약수로 나눈 몫의 값을 가진 작은 사각형들의 패턴이 있다는 사실에 충격 (고등학생이였으면 30분 만에 풀었다)
        // (w / gcd) + (h / gcd) - 1 의 패턴이 존재 심지어 최대공약수 의 배 만큼 가짐
        // ((w / gcd) + (h / gcd) - 1) * gcd 인데 분배법칙 쓰면 w + h - gcd 요딴 모양이 나옴
        // 그리고 w h 에 int 보다 큰 수를 넣는다고 한다...
        return answer;
    }
    public int gcd(int a, int b) {      // 최대공약수 구하는 재귀함수
        if(a%b == 0)        // b의 a를 나눠서 0이 나오면 그게 최대공약수가 되는것 
            return b;
        return gcd(b, a%b); // a를 b로 나눈 나머지가 와 b로 최대공약수 계산
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(8, 12));
    }
}
// 재귀함수로 최대공약수 (종이가 클수록 함수호출이 늘어남) 한번에 구하는 식이 좋을듯
// 유클리드 호제법? 이 좋다고 한다. 그게뭔데 씹덕아