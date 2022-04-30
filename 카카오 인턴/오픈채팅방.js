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

// 어째서인지 find 함수 쓰는것 보다 Map(Dictionary)로 찾는게 훨신 빠르게 처리된


function solution1(record) {
    const splitRecord = [];
    const uidNickname = {};
    var answer = [];
    record.forEach(r => {
        const s = r.split(' ');
        splitRecord.push([s[0], s[1]])
        if(s[2]) {
            uidNickname[s[1]] = s[2];
        }
    });
    splitRecord.forEach(r => {
        let msg;
        if(r[0] === 'Enter') {
            msg = '님이 들어왔습니다.'
        }
        else if(r[0] === 'Leave') {
            msg =  '님이 나갔습니다.'
        }
        if(msg) {
            answer.push(`${uidNickname[r[1]]}${msg}`);
        }
    })

    return answer;
}


console.log(solution1(record));