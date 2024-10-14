import java.util.*;

/*
아이디어 : 먼저 인물과 인물에 대한 그리움 값을 Map으로 저장해두고, photo에 대해 반복문을 돌면서 각 사진의 그리움 점수 총 값을 저장한다.
시간복잡도 : O(N), N은 photo 배열의 행*열 
자료구조 : 배열
*/

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        int temp = 0;
        
        Map<String, Integer> record = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            record.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++){
            temp = 0;
            
            for(int j = 0; j < photo[i].length; j++){
                temp += record.getOrDefault(photo[i][j], 0);                
            }
            
            answer[i] = temp;
            
        }
        
        return answer;
        
    }
}