import java.util.*;

/*
아이디어 : 문자열을 돌면서 해당 알파벳과 위치가 map에 기록되어 있는지 확인하고, 없으면 answer 배열에 -1 저장, 있으면 해당 인덱스와의 차이를 구해서 answer에 저장하고 map에는 새로운 알파벳의 위치를 업데이트 시켜준다.
시간복잡도 : O(N), N은 문자열 s의 길이
자료구조 : array, map
*/

class Solution {
    public int[] solution(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        int indexBefore = 0;
                
        for (int i = 0; i < s.length(); i++) {

            Character current = s.charAt(i);
            indexBefore = map.getOrDefault(current, -1);
            
            if(indexBefore == -1){
                answer[i] = -1;
                map.put(current, i);
            }
            else {
                answer[i] = i - indexBefore;
                map.put(current, i);
            }

        }
        
        return answer;
    }
}