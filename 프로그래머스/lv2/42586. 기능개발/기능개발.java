import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] days = new int[progresses.length];
        int countDay = 0;
        ArrayList<Integer> results = new ArrayList<>();
        int pointer = 0;

        for(int i = 0; i < progresses.length; i++){
            if ((100 - progresses[i]) % speeds[i] == 0) {
                countDay = (100 - progresses[i]) / speeds[i];
                days[i] = countDay;
            }
            else days[i] = ((100 - progresses[i]) / speeds[i]) + 1;
        }
        //각 작업별 필요한 일 수를 넣은 배열은 완성함
        //거기서 return값을 구하는것만 구현해보기!

        for(int i = 0; i < days.length; i++){
            for(int j = i+1; j < days.length; j++){
                if(days[i] < days[j]){
                    pointer = j;
                    results.add(pointer - i);
                    break;
                }
            }
            if(pointer == 0) {
                results.add(days.length - i);
                break;
            }
            else{
                i = pointer -1;
                pointer = 0;
            }
        }
        

        answer = new int[results.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = results.get(i);
        }

        return answer;
    }
}