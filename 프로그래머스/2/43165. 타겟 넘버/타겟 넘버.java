class Solution {

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, numbers.length);
    }

    public int dfs(int[] numbers, int target, int index, int maxLength) {
        if (index == maxLength) {
            return target == 0 ? 1 : 0;
        }
        int sum = 0;
        target += numbers[index];
        sum += dfs(numbers, target, index + 1, maxLength);
        target -= numbers[index];
        target -= numbers[index];
        sum += dfs(numbers, target, index + 1, maxLength);
        return sum;
    }
}
