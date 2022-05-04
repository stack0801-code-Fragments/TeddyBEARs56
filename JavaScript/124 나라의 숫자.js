function solution(n) {
    var answer = '';
    let num;

    while(n > 0){
        num = n%3

        if(num == 0 ){
            answer = 4 + answer;
            n = n / 3 - 1;
        }
        else{
            answer = num + answer;
            n = parseInt(n/3);
        }
    }
        
    return answer;
}

console.log(solution(9));