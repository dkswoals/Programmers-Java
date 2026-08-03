class Solution {

    int[] dp = new int[100001];

    int m = 1234567;

    public int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (this.dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = (solution(n - 1) % m + solution(n - 2) % m) % m;
    }
}