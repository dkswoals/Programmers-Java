class Solution {

    public String solution(String new_id) {
        new_id = new_id.toLowerCase()
                .replaceAll("[[^a-z0-9\\-_.]]", "")
                .replaceAll("\\.{1,}", ".")
                .replaceAll("^\\.", "")
                .replaceAll("\\.$", "");

        if (new_id.isEmpty()) {
            new_id = "a";
        }

        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15)
                    .replaceAll("\\.$", "");
        }
        StringBuilder sb = new StringBuilder(new_id);
        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        return sb.toString();
    }
}