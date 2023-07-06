import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> temp = new ArrayList<>();
        
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] != arr[i+1]) temp.add(arr[i]);    
        }
        temp.add(arr[arr.length-1]);
        answer = new int[temp.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = temp.get(i);
        }
        

        return answer;
    }
}