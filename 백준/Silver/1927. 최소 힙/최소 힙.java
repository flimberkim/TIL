//시간복잡도 : O(NlogN), N은 입력받는 횟수
//아이디어 : 입력 받는 값에 따라 큐에 삽입하거나, 최소값을 꺼내온다.
//자료구조 : 우선순위 큐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < caseNum; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if (que.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(que.poll()).append("\n");
                }
            }
            else {
                que.add(num);
            }
        }
        System.out.println(sb.toString());
    }
}