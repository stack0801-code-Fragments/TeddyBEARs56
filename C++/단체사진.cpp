#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int max_count;

void loop(int n, int clear, int count, vector<string> data, vector<string> kakao_friends, vector<string> line) {

    line.push_back(kakao_friends[count]);   // 새로운 벡터에 추가
    kakao_friends.erase(kakao_friends.begin() + count);     // 친구 벡터에서 제거

    if (kakao_friends.size() == 0) {
        int check = 0;  // 두명의 친구가 line에 존재하는지
        for (int i = 0; i < n; i++) {
            string cmp1, cmp2;  //algorithm의 find 함수를 사용할때 line의 string과 형식을 같이 하기 위해 만든 변수
                cmp1 = data[i][0];  // char to string
                cmp2 = data[i][2];  // char to string
                int item_cmp = abs((find(line.begin(), line.end(), cmp1) - line.begin()) - (find(line.begin(), line.end(), cmp2) - line.begin()));  // 한조건의 두친구 간격구하기
                int distance = data[i][4] - 47; // 두친구의 조건 거리
                if (data[i][3] == '<') {           // 두친구의 조건
                    if (item_cmp < distance) {
                        check++;
                    }
                }
                else if (data[i][3] == '>') {
                    if (item_cmp > distance) {
                        check++;
                    }

                }
                else if (data[i][3] == '=') {
                    if (item_cmp == distance) {
                        check++;
                    }
                }
            }
            if (check == 2) {   // 두조건에 만족했다면
                max_count++;
            }
        
    }
    for (int i = 0; i < kakao_friends.size(); i++) {        // 한무 함수
        loop(n, clear, i, data, kakao_friends, line);
    }
}


// 이코드는 글렀나봄.... 다시 만들어보자

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {     
    int answer = 0;
    vector<string> kakao_friends= { "A","C","F", "J", "M", "N", "R","T" };
    vector<string> line;
    for (int i = 0; i < kakao_friends.size(); i++) {
        loop(n, 0, i, data, kakao_friends, line);
    }
    answer = max_count;
    return answer;
}