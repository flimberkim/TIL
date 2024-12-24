import java.util.*;

/*
아이디어 : 두개의 StringBuilder를 두고 작업한다. 첫번째 sb에 food 배열을 돌면서 음식의 개수를 2로 나눈 값만큼 반복해서 추가.
다음 sb에 역순 문자열을 추가. 최종적으로 원래의 순서 + 물(0) + 역순 을 출력한다.
자료구조 : array
시간복잡도 : O(N), N은 food 배열의 크기
*/

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(int i = 1; i < food.length; i++){
            count = food[i]/2;
            
            for(int j = 0; j < count; j++){
                sb.append(i);
            }
            
        }
        
        StringBuilder sb2 = new StringBuilder();
        String first = sb.toString();
        
        sb2.append(sb.reverse());
        sb = new StringBuilder();
        
        sb.append(first).append(0).append(sb2.toString());
        
        return sb.toString().trim();
    }
}