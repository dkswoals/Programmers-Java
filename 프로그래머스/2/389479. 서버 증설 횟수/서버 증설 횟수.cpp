#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> players, int m, int k)
{
    int answer = 0;
    vector<int> servers;

    for (int i = 0; i < 24; i++)
    {
        for (int j = 0; j < servers.size(); j++)
        {
            servers[j]--;
            if (servers[j] == 0){
                servers.erase(servers.begin() + j);
                j--;
            }
        }
        int need_to_add = players[i] / m - servers.size();
        if (need_to_add > 0)
        {
            for (int j = 0; j < need_to_add; j++)
                servers.push_back(k);
            answer += need_to_add;
        }
    }

    return answer;
}
