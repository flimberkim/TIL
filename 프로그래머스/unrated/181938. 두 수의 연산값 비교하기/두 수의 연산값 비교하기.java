class Solution {
    public int solution(int a, int b) {
        
        StringBuilder sb = new StringBuilder();
        int first = Integer.valueOf(sb.append(String.valueOf(a)).append(String.valueOf(b)).toString());
        int second = 2*a*b;
        
        return first >= second? first : second;
    }
}