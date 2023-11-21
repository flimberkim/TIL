import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> memo = new HashMap<>();
        int sum = 0;

        for(int i = 0; i < name.length; i++){
            memo.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++){
            String[] temp = photo[i];

            for(int j = 0; j < temp.length; j++){
                if(memo.containsKey(temp[j])){
                    sum += memo.get(temp[j]);
                }
            }
            answer[i] = sum;
            sum = 0;
        }
        
        return answer;
    }
}