//시간복잡도 : O(N), N은 테스트케이스의 개수
//아이디어 : 모든 노드가 연결되어 있다고 했으므로, 가장 최소로 비행기를 타는 경우는 항상 노드개수 - 1이다.
//          이 조건이 없다면 DFS나 Backtracking으로 풀어야 할 듯..
//자료구조 : 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = Integer.parseInt(input.readLine());

        for(int i = 0; i < caseNum; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int countryNum = Integer.parseInt(st.nextToken());
            int flightNum = Integer.parseInt(st.nextToken());

            for(int j = 0; j < flightNum; j++) {
                StringTokenizer st2 = new StringTokenizer(input.readLine());
            }
            sb.append(countryNum - 1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
