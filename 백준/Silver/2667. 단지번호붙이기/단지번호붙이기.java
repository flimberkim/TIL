import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static List<Integer> houseNums = new ArrayList<>();
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
/*
        1. 아이디어 : 2중 for 문을 돌면서 값이 1이면서 방문하지 않은 곳을 대상으로 DFS 탐색
        방문하지 않은 곳 중 탐색할 곳을 발견하면 단지수 + 1 하고 해당 단지에 속한 집의 개수를 구한다.
        2. 시간복잡도 : O(V+E) , V = 행렬의 크기(n*n), E는 평균적으로 하나당 상하좌우 4개의 경우가 있으므로 4V라고 생각
        결국 O(5V) = O(V) ~= n^2 ( 최대 625, 2억보다 작으므로 시간은 문제 X)
        3. 자료구조
        - 그래프 전체 지도 : int[][]
        - 반문여부 체크 : bool[][]
*/
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = row;
        graph = new int[row][col];
        visited = new boolean[row][col];

        //그래프를 입력받아서 저장
        for (int i = 0; i < row; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                graph[i][j] = line[j] - '0';
            }
        }

        //DFS 함수 호출
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    visited[i][j] = true;
                    DFS(j, i);
                    houseNums.add(count);
                    count = 0;
                }
            }
        }

        sb.append(houseNums.size()).append("\n");
        Collections.sort(houseNums);
        for (Integer houseNum : houseNums) {
            sb.append(houseNum).append("\n");
        }

        System.out.println(sb.toString());

    }

    //x가 열, y가 행
    public static void DFS(int x, int y) {

        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= ny && ny <= graph.length - 1 && 0 <= nx && nx <= graph.length - 1) {
                if (!visited[ny][nx] && graph[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    DFS(nx, ny);
                }
            }
        }
    }

}