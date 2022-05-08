function solution(n) {
    var answer = '';
    let num;

    while(n > 0){
        num = n % 3         // 3진수화 하기 위해 나머지값 이용

        if(num == 0 ){      // 나머지가 0인경우는 자릿수가 늘어나기 때문에 따로 처리
            num = 4 ;       // 자릿수 늘리지 않고 뒤에 4로 표기
            n = n / 3 - 1;  // 자릿수 늘리지 않게 하기 위해 나머지 값 계산할 수 있도록 남김(-1) : 3의 배수기이 때문에 parseInt하지 않음
        }
        else{
            n = parseInt( n / 3 );       
        }
        answer = num + answer   // 결과 만들기
    }
        
    return answer;
}

console.log(solution(9)); 