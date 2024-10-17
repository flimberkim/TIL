import java.util.*;

/*
아이디어 : 3진법의 변형으로 이루어지는 방식을 파악하고, 주어진 숫자에 변환방법을 적용해서 새로운 문자열을 구한다.
시간복잡도 : O(N), N은 주어진 숫자 n의 길이
자료구조 : map
*/

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"4", "1", "2"};
        while(n > 0) {
            int tmp = n % 3;
            n /= 3;
            if(tmp == 0) {
                n--;
            }
            answer = arr[tmp] + answer;
        }

        return answer;
    }
}