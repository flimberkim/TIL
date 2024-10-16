import java.util.*;

/*
아이디어 : 먼저 keymap을 확인해서 각 알파벳을 얻기 위한 최소 횟수를 저장해두고, targets를 돌면서 최소횟수를 구한다.
시간복잡도 : O(NM), N은 keymap의 길이, M은 keymap[i]의 길이
자료구조 : 배열
*/

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int count = 0;
        String[] temp;
        
        Map<String, Integer> record = new HashMap<>();
        
        //각 알파벳을 얻기 위한 최소 횟수를 저장
        for(int i = 0; i < keymap.length; i++){
            temp = keymap[i].split("");
            
            for(int j = 0; j < temp.length; j++){
                if(record.containsKey(temp[j])){
                    record.put(temp[j], Math.min(record.get(temp[j]), j+1));
                }
                else{
                    record.put(temp[j], j+1);
                }
            }
            
        }
        
        for(int i = 0; i < targets.length; i++){
            temp = targets[i].split("");
            
            for(int j = 0; j < temp.length; j++){
                try{
                    count += record.get(temp[j]);
                }
                catch(Exception e){
                    count = -1;
                    break;
                }
                
            }
            
            answer[i] = count;
            count = 0;
        }
        
        return answer;
    }
}