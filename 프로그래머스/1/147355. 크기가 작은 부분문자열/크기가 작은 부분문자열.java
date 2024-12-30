import java.util.*;

/*
아이디어 : p의 길이만큼 끊어서 t를 돌면서 숫자를 비교한다. 그때마다 조건에 해당되면 answer에 1을 더한다.
자료구조 : array
시간복잡도 : O(N), N은 String t의 길이
*/

class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        long pNum = Long.parseLong(p);
        long temp = 0;
        int size = p.length();

        char[] arr = t.toCharArray();

        for (int i = 0; i < t.length() - size + 1; i++) {
            for (int j = i; j < i + size; j++) {
                sb.append(arr[j]);
            }

            // if (sb.charAt(0) == '0' && sb.length() > 1) {
            //     while(sb.charAt(0) == '0'){
            //         sb.deleteCharAt(0);
            //     }
            // }

            temp = Long.parseLong(sb.toString());

            if (temp <= pNum) {
                answer++;
            }

            sb = new StringBuilder();
        }


        return answer;
    }
}