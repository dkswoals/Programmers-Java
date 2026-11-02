class Solution {

    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        System.out.println(new_id);
        for (char c : new_id.toCharArray()) {
            if ((c < 'a' || c > 'z') && !Character.isDigit(c)) {
                if (c == '.' || c == '_' || c == '-') {
                    answer = answer.concat(String.valueOf(c));
                }
            } else answer = answer.concat(String.valueOf(c));
        }
        System.out.println(answer);
        String temp = String.valueOf(answer.charAt(0));
        for (int i = 1; i < answer.length(); i++) {
            if (answer.charAt(i) == '.') {
                if (answer.charAt(i - 1) != '.') {
                    temp = temp.concat(String.valueOf(answer.charAt(i)));
                }
            } else {
                temp = temp.concat(String.valueOf(answer.charAt(i)));
            }
        }
        System.out.println(temp);
        if (temp.startsWith(".")) {
            temp = temp.substring(1);
        }

        if (temp.endsWith(".")) {
            temp = temp.substring(0, temp.length() - 1);
        }

        if (temp.isEmpty()) {
            temp = temp.concat("a");
        }

        if (temp.length() > 15) {
            temp = temp.substring(0, 15);
            if (temp.endsWith(".")) {
                temp = temp.substring(0, temp.length() - 1);
            }
        }
        System.out.println(temp);
        while (temp.length() <= 2) {
            temp = temp.concat(String.valueOf(temp.charAt(temp.length() - 1)));
        }
        System.out.println(temp);
        return temp;
    }
}
