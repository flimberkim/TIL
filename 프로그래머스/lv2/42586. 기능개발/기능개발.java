import java.util.*;

//시간복잡도 : O(N), N은 progresses 배열의 길이
//아이디어 : 먼저 progresses와 같은 길이의 배열을 만들고, 해당 작업이 완료될 날짜를 담은 배열을 구한다. 날짜를 담은 배열을 처음부터 돌면서 현재 값보다 더 커지는 순간으로 포인트를 옮겨가며 함께 배포 되는 작업의 개수를 구한다.
//자료구조 : 배열


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