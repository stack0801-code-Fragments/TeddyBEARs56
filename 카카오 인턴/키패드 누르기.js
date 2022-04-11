function solution(numbers, hand) {
    let leftHand = [0, 3]; 
    let rightHand = [2, 3];
    let leftFar = 0;
    let rightFar = 0;
    var answer = '';
    let matrix = [
        [ 1, 4, 7],
        [ 2, 5, 8, 0 ],
        [ 3, 6, 9]
    ]
    function inputNum(hand, coordinate, number){
        answer += hand;
        if(hand == 'L') leftHand = [coordinate, matrix[coordinate].indexOf(number)];
        else rightHand = [coordinate, matrix[coordinate].indexOf(number)];
    }
    for(let number of numbers){
        if(matrix[1].indexOf(number) >= 0){
            leftFar = Math.abs(leftHand[0] - 1 ) + Math.abs(leftHand[1] - matrix[1].indexOf(number))
            rightFar = Math.abs(rightHand[0] - 1) + Math.abs(rightHand[1] - matrix[1].indexOf(number))
            if( leftFar == rightFar ){
                if(hand == 'left') inputNum('L', 1, number);
                else inputNum('R', 1, number);
            }
            else if( leftFar < rightFar ) inputNum('L', 1, number);
            else inputNum('R', 1, number);
        }
        else if(matrix[0].indexOf(number) >= 0)  inputNum('L', 0, number);
        else inputNum('R', 2, number);
    }
    console.log(answer);
    return answer;
}