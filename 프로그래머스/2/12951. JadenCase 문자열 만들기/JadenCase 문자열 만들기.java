class Solution {
    public String solution(String s) {
      char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(chars[i])) {
                if (i == 0 || chars[i - 1] == ' ') {
                    chars[i] = Character.toUpperCase(chars[i]);
                } else {
                    chars[i] = Character.toLowerCase(chars[i]);
                }
            }
        }
        return new String(chars);
    }
}