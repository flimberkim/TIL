import java.util.*;

/*
아이디어 : 각 카드 뭉치를 각각의 큐에 저장한다. 그리고 목표하는 단어들이 있는지 확인하고 있으면 큐에서 순서대로 제거한다.
시간복잡도 : O(N), N은 goal의 길이
자료구조 : 배열, 큐
*/

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> cardSet1 = new LinkedList<>();
        Queue<String> cardSet2 = new LinkedList<>();
        
        for(int i = 0; i < cards1.length; i++){
            cardSet1.add(cards1[i]);
        }
        
        for(int i = 0; i < cards2.length; i++){
            cardSet2.add(cards2[i]);
        }
        
        for(int i = 0; i < goal.length; i++){
            if(!cardSet1.isEmpty() && cardSet1.peek().equals(goal[i])){
                cardSet1.poll();
            }
            else if(!cardSet2.isEmpty() && cardSet2.peek().equals(goal[i])){
                cardSet2.poll();
            }
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}