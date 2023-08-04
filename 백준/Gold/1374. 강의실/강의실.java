//시간복잡도 : O(NlogN), N은 강의의 개수
//아이디어 : 시작시간과 종료시간을 저장한 Lesson 객체를 만든다. 객체를 저장한 배열을 시작시간 기준으로 정렬한다.
//          우선순위큐에 끝나는 시간만 저장하고 다음 Lesson의 시작시간과 비교하며 조건에 따라 처리한다.
//자료구조 : 우선순위큐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        List<Lesson> lessons = new ArrayList<>();
        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lessons.add(new Lesson(start, end));
        }

        Collections.sort(lessons);

        int answer = 1;

        for(int i = 0; i < num; i++){
            while(!que.isEmpty() && que.peek() <= lessons.get(i).start){
                que.poll();
            }
            que.add(lessons.get(i).end);
            answer = Math.max(answer, que.size());
        }
        System.out.println(answer);
    }

    static class Lesson implements Comparable<Lesson>{
        int start;
        int end;
        public Lesson(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Lesson o){
            if(this.start == o.start){
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}

