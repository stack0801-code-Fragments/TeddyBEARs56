function solution(s) {
    const item = {
        old_str: '',
        real_str: '',
        real_old_str: '',
        count: 1,
        min_length: 0
    }
    item.min_length = s.length;
    for(let num1 = 1; num1 <= s.length/2;  num1++){
        for(let num2 = 0; num2 < s.length; num2 += num1){
            if(s.slice(num2, num2+num1) === item.old_str){
                item.real_str = item.real_str.slice(0, -item.real_old_str.length)
                item.real_str += item.real_old_str = ++item.count + s.slice(num2, num2+num1);
            }
            else{
                if(item.count > 1) item.count = 1;
                item.real_str += item.real_old_str = s.slice(num2, num2+num1);
            }
            item.old_str = s.slice(num2, num2+num1);
        }
        if(item.min_length > item.real_str.length){
            item.min_length = item.real_str.length
        }
        item.count = 1;
        item.real_str = '';
        
    }
    return item.min_length
}

console.log(solution('xxxxxxxxxxyyy'));