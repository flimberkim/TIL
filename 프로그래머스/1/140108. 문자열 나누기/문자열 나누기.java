import java.util.*;

/*
아이디어 : 문자열을 돌면서 기준이 되는 문자를 고르고 비교해 나간다. 숫자가 같아지는 순간 turnOver라는 플래그를 변경시켜주고 기준이 되는 문자를 초기화 해준다. 마지막 부분 예외처리만 해주면 끝.
자료구조 : String
시간복잡도 : O(N), N은 문자열 s의 길이
*/

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int standardNum = 0;
        int differentNum = 0;
        boolean turnOver = false;
        char temp = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++){
            
            if(turnOver){
                temp = s.charAt(i);
                turnOver = false;
            }
            
            if(temp == s.charAt(i)){
                standardNum++;
            }
            else{
                differentNum++;
            }
            
            if(standardNum == differentNum){
                answer++;
                standardNum = 0;
                differentNum = 0;
                turnOver = true;
            }
            else if(i == s.length()-1){
                answer++;
            }
            
        }
        return answer;
    }
}