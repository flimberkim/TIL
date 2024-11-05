import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
아이디어 : 방을 사용하는 시간 중, 끝나는 시간을 기준으로 정렬한다. 그 후 모든 방 대실 시간을 탐색하면서 끝나는 시간이 겹치는 방들의 개수를 구한다. 최대로 많이 겹치는 방의 수를 answer에 저장한다.
시간복잡도 : O(N^2), N은 book_time.length
자료구조 : array
*/


class Solution {
    public int solution(String[][] book_time) {
       int answer = 0;
        
        int[][] bookTime = new int[book_time.length][2];
        
        for (int i = 0; i< book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end += 10; // 청소 시간
            
            if (end % 100 >= 60) {
                end += 40;
            }
            
            bookTime[i][0] = start;
            bookTime[i][1] = end;
            
        }
        
        Arrays.sort(bookTime, (a1, a2) -> {
            return a1[0]-a2[0];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        for (int[] book : bookTime) {
            
            if (pq.isEmpty()) {
                pq.add(book);
            } else {
                int[] tmp = pq.peek();
                int start = tmp[0];
                int end = tmp[1];
                
                if (book[0] >= end) {
                    pq.poll();
                }
                pq.add(book);
            }
            
        }

        answer = pq.size();
        return answer;
        
    }
}