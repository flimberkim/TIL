import java.util.*;

/*
아이디어 : 페인트를 칠해야 하는 구역이 오름차순으로 정렬되어 있으므로, 첫번째 구역을 기준으로 먼저 1번 칠한다. 매번 칠해진 마지막 구역만 업데이트 하며 구역을 체크해 나간다.
시간복잡도 : O(N), N은 section의 길이
자료구조 : 배열
*/

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int right = section[0] + m - 1;
        
        for (int i = 0; i < section.length; i++) {
            // 현재 구간이 마지막으로 칠한 구간의 끝점을 넘으면 다시 페인트칠
            if (section[i] > right) {
                answer++;  // 페인트 칠 횟수 증가
                right = section[i] + m - 1;  // 새로 페인트 칠한 구간의 끝점
            }
        }
        
        return answer;
    }
}