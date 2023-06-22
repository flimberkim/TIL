import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> nums = new HashSet<>();
        int countZero = 0;
        int countGood = 0;
        
        for(int i : win_nums){
            nums.add(i);
        }
        
        for(int i : lottos){
            if(i == 0){
                countZero++;
            }
            else if(nums.contains(i)){
                countGood++;
            }
        }
        int temp = (6 -(countZero+countGood))+1;
        if(temp >= 6) answer[0] = 6;
        else answer[0] = temp;
        
        temp = (6 - countGood)+1;
        if(temp >= 6) answer[1] = 6;
        else answer[1] = temp;

        return answer;
    }
}