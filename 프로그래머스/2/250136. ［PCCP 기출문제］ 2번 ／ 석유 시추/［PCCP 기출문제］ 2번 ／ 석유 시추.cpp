#include <vector>
#include <queue>
#include <unordered_set>
#include <algorithm>

using namespace std;

struct Node {
    int y, x;
};

// 상하좌우 방향
const int dy[] = {-1, 1, 0, 0};
const int dx[] = {0, 0, -1, 1};

int bfs(int startY, int startX, vector<vector<int>>& land, vector<int>& oilPerColumn) {
    int n = land.size();
    int m = land[0].size();
    
    queue<Node> q;
    unordered_set<int> columns; // 실제 석유가 있는 열들
    int oilCount = 0;
    
    // 시작점 처리
    q.push({startY, startX});
    land[startY][startX] = 2; // 방문 표시 (0: 빈땅, 1: 석유, 2: 방문됨)
    
    while (!q.empty()) {
        Node current = q.front();
        q.pop();
        
        oilCount++;
        columns.insert(current.x);
        
        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int ny = current.y + dy[i];
            int nx = current.x + dx[i];
            
            // 경계 체크 및 석유 체크
            if (ny >= 0 && ny < n && nx >= 0 && nx < m && land[ny][nx] == 1) {
                q.push({ny, nx});
                land[ny][nx] = 2; // 방문 표시
            }
        }
    }
    
    // 해당 덩어리가 지나는 모든 열에 석유량 추가
    for (int col : columns) {
        oilPerColumn[col] += oilCount;
    }
    
    return oilCount;
}

int solution(vector<vector<int>> land) {
    int n = land.size();
    int m = land[0].size();
    
    vector<int> oilPerColumn(m, 0);
    
    // 모든 셀을 검사하여 석유 덩어리 찾기
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (land[i][j] == 1) {
                bfs(i, j, land, oilPerColumn);
            }
        }
    }
    
    // 가장 많은 석유를 얻을 수 있는 열 찾기
    return *max_element(oilPerColumn.begin(), oilPerColumn.end());
}