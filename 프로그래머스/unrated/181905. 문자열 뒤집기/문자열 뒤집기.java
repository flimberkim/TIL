class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);
        StringBuilder sub = new StringBuilder(sb.substring(s, e+1));
        String reverse = sub.reverse().toString();

        sb.replace(s, e+1, reverse);
        return sb.toString();
    }
}