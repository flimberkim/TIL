import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

/*
        1. 아이디어 : 먼저 풍선의 순서와 안에 적인 종이의 숫자를 map 에 기록해준다. 그리고 주어진 풍선을 순서대로 덱에 기록한다.
        덱의 맨 앞에서부터 하나씩 뽑는다. 뽑은 수가 양수인지 음수인지 따라서 앞에서 뽑아서 뒤에 붙일지, 뒤에서 뽑아서 앞에 붙일지 결정한다.
        change라는 확인용 변수를 두고 반복문에서 판단한다.
        2. 시간복잡도 : O(N), N은 덱의 크기
        3. 자료구조 : deque, map
*/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine()); // 풍선 개수
        StringTokenizer st = new StringTokenizer(input.readLine());
        
        int[] balloons = new int[N];
        for (int i = 0; i < N; i++) {
            balloons[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[] visited = new boolean[N]; // 풍선 터뜨린 상태 추적
        StringBuilder sb = new StringBuilder();
        
        int current = 0; // 시작 위치
        int count = 0;   // 터뜨린 풍선 개수
        
        while (count < N) {
            sb.append(current + 1).append(" ");
            visited[current] = true;
            count++;
            
            if (count == N) break; // 모든 풍선을 터뜨렸다면 종료
            
            int step = balloons[current]; // 현재 풍선에 적힌 숫자
            int direction = step > 0 ? 1 : -1; // 이동 방향 결정
            
            // 다음 위치 계산
            int move = Math.abs(step);
            while (move > 0) {
                current = (current + direction + N) % N; // 원형으로 이동
                if (!visited[current]) move--; // 방문하지 않은 풍선만 이동
            }
        }
        
        System.out.println(sb.toString().trim());
    }
}