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
    }
    let arr;
    for(let con of record){
        arr = con.split(' ');

        if(arr[0] === 'Enter'){
            item.user[arr[1]] = arr[2]
            item.log.push({id: arr[1], commend: "님이 들어왔습니다."})
        }
        else if(arr[0] === 'Leave'){
            item.log.push({id: arr[1], commend: "님이 나갔습니다."})
        }
        else if(arr[0] ===  'Change'){
            item.user[arr[1]] = arr[2]   
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