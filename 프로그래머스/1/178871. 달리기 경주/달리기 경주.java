import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> memo = new HashMap<>();
        
        String player1;
        String player2;
        int player1Index = 0;
        int player2Index = 0;
        int temp;
        
        //맵에 선수와 등수를 기록
        for(int i = 0; i < players.length; i++){
            memo.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            player1 = callings[i];
            player1Index = memo.get(player1);
            player2Index = player1Index - 1;
            player2 = players[player2Index];
            temp = player1Index;
            memo.put(player1, player2Index);
            memo.put(player2, temp);
            players[player1Index] = player2;
            players[player2Index] = player1;
        }
          
        return players;
    }
}