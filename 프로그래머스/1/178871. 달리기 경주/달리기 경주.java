import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> memo = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            memo.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            int index = memo.get(callings[i]);
            
            //추월당할 선수 찾아놓기
            String temp = players[index-1];
            players[index-1] = players[index];
            players[index] = temp;
            
            //추월당한 선수의 인덱스를 갱신
            memo.put(players[index], index);
            memo.put(players[index-1], index-1);
        }

        return players;
    }
}