class Solution {
    public int solution(int n) {
        int count = countBinaryBit(n);
        for (int i = n + 1; ; i++) {
            if (count == countBinaryBit(i)) {
                return i;
            }
        }
    }

    private static int countBinaryBit(int n) {
        int count = 0;
        while (n != 0) {
            count += n % 2;
            n /= 2;
        }
        return count;
    }
}