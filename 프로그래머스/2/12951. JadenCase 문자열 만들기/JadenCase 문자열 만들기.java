class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        String[] arr = s.split(" ", -1);

        for (String now : arr) {

            if (now.length() == 0) {
                sb.append(" ");
                continue;
            }

            sb.append(now.substring(0, 1).toUpperCase());
            sb.append(now.substring(1).toLowerCase());
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}