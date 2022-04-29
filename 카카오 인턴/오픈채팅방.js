let record = [
    "Enter uid1234 Muzi",
    "Enter uid4567 Prodo",
    "Leave uid1234",
    "Enter uid1234 Prodo",
    "Change uid4567 Ryan"
]

function solution(record) {

    const item = {
        answer: [],
        log: [],
        user: [],
        check: -1,
        arr: []
    }
    
    for(let con of record){
        item.arr = con.split(' ');

        if(item.arr[0] === 'Enter'){
            item.user[item.arr[1]] = item.arr[2]
            item.log.push({id: item.arr[1], commend: "님이 들어왔습니다."})
        }
        else if(item.arr[0] === 'Leave'){
            item.log.push({id: item.arr[1], commend: "님이 나갔습니다."})
        }
        else if(item.arr[0] ===  'Change'){
            item.user[item.arr[1]] = item.arr[2]   
        }
    }

    for(let commend of item.log){
        item.answer.push(item.user[commend.id] + commend.commend);
        
    }

    return item.answer;
}

console.log(solution(record));
// ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

// 어째서인지 find 함수 쓰는것 보다 Map(Dictionary)로 찾는게 훨신 빠르게 처리된다.