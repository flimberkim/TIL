import java.util.*;

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        sb.append(ineq).append(eq);

        switch(sb.toString()){
            case ">=":
                answer = n >= m ? 1 : 0;
                break;
            case "<=":
                answer = n <= m ? 1 : 0;
                break;
            case ">!":
                answer = n > m ? 1 : 0;
                break;
            case "<!":
                answer = n < m ? 1 : 0;
                break;
        }
        return answer;
    }
}