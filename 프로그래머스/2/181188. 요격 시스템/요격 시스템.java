import java.util.*;

/*
아디이어 : 각 미사일의 요격 범위를 끝나는 점 기준으로 오름차순 정렬한다. 한 범위에 대해서 최대한 마지막 점에서 요격하면 이후의 범위에 최대한 들어갈 수 있다. 이를 이용해 최소 요격 개수를 결정한다.
시간복잡도 : O(N), N은 targets의 length
자료구조 : array
*/

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int before = 0;
        for(int i=0;i<targets.length;i++){
            if(before <= targets[i][0]){
                before = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}