#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int max(int a, int b)
{
    if (a > b)
        return a;
    else
        return b;
}

int solution(vector<vector<int>> info, int n, int m)
{
    int answer = 0, sum_a = info[0][0];

    int dp[40][120] = {0};
    for (int i = info[0][1]; i < m; i++)
        dp[0][i] = info[0][0];

    for (int i = 1; i < info.size(); i++)
    {
        sum_a += info[i][0];
        for (int j = 0; j < m; j++)
        {
            if (j < info[i][1])
                dp[i][j] = dp[i - 1][j];
            else
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - info[i][1]] + info[i][0]);
        }
    }
    answer = sum_a - dp[info.size() - 1][m - 1];
    if (answer >= n)
        return -1;
    return answer;
}
