#include <vector>

using namespace std;

int check_x = 0;
int check_y = 0;
int v_count = 0;

class Point {
private:
    int x;
    int y;
public:
    Point(int x, int y) {
        this->x = x;
        this->y = y;
    }
    int get_x() {
        return this->x;
    }
    int get_y() {
        return this->y;
    }
};

vector<Point> check_Point{
        Point(-1, 0),
        Point(1, 0),
        Point(0, -1),
        Point(0, 1)
};



void search(int x, int y, vector<vector<int>> &check, vector<vector<int>> &picture) {
    check[x][y]++;
    v_count++;
    for (int num = 0; num < 4; num++) {
        check_x = x + check_Point[num].get_x();
        check_y = y + check_Point[num].get_y();

        if ( check_x >= 0 && check_y >= 0 && check_x < picture.size() && check_y < picture[0].size()) {
            if(check[check_x][check_y] == 0 && picture[x][y] == picture[check_x][check_y])
            search(check_x, check_y, check, picture);
        }
    }
}


// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    
    int number_of_area = 0;
    int max_size_of_one_area = 0;

    vector<vector<int>> check(m, vector<int>(n, 0));
    
    for (int x = 0; x < m; x++) {
        for (int y = 0; y < n; y++) {
            if (check[x][y] == 0 && picture[x][y] != 0) {
                number_of_area++;
                search(x, y, check, picture);
            }
            if (max_size_of_one_area < v_count) {
                max_size_of_one_area = v_count;
            }
            v_count = 0;
        }
    }

    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}

int main() {
    vector<vector<int>> picture{
        {1, 1, 1, 0},
        {1, 2, 2, 0},
        {1, 0, 0, 1},
        {0, 0, 0, 1},
        {0, 0, 0, 3},
        {0, 0, 0, 3}
    };

    vector<int> answer = solution(6, 4, picture);

    for (int x = 0; x < answer.size(); x++) {
        printf("%d ", answer[x]);
    }

    //for (int x = 0; x < picture.size(); x++) {
    //    for (int y = 0; y < picture[x].size(); y++) {
    //        printf("%d ", picture[x][y]);
    //    }
    //    printf("\n");
    //}
    return 0;
}