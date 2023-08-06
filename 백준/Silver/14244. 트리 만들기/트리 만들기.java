//시간복잡도 : O(N), N은 주어진 노드의 개수
//아이디어 : 출력값이 순차적으로 가기 때문에, 먼저 0과 1을 연결해주고 카운트를 +1 해주고 시작한다.
//         다음으로 리프노드의 수를 만족할 때까지 나머지 노드를 1과 연결해주고, 조건이 만족하면 마지막 노드에 나머지 노드들을 다 연결한다.
//자료구조 : 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int num = 2;
        int count = 1;

        sb.append(0).append(" ").append(1).append("\n");

        while (true) {
            if (count == m){
                while (num < n) {
                    sb.append(num - 1).append(" ").append(num).append("\n");
                    num++;
                }
                break;
            }
            sb.append(1).append(" ").append(num++).append("\n");
            count++;
        }
        System.out.println(sb.toString());
    }
}
