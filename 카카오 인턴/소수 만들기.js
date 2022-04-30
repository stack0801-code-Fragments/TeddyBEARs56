function primeNum(num){
    if (num == 1){ return false }
    else if(num == 2){ return true }
    else{
        for(let i = 2; i*i <= num; i++){ if( num % i == 0) return false }
        return true
    }
}
function solution(nums) {
    var answer = 0;
    for(let num1 = 0; num1<nums.length - 2; num1++){
        for(let num2 = num1 + 1; num2<nums.length - 1; num2++){
            for(let num3 = num2 + 1; num3<nums.length; num3++){
                if (primeNum(nums[num1]+nums[num2]+nums[num3])){ answer++; }
            }
        }
    }
    return answer;
}

console.log(solution([1,2,3,4]));