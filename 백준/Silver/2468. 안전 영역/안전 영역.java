import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int maxNum = 1;
    static int count = 0;
    static int minHeight = 101;
    static int maxHeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : 주어진 대로 그래프를 입력하면서 최소 높이와 최대 높이를 기록해 둔다. 각각의 높이에 대해서 그래프를 탐색하면서 최대 안전 영역의 개수를 구한다.
        2. 시간복잡도 : O(N^3), N은 행과 열의 개수
        3. 자료구조
        - 그래프 전체 지도 : int[][]
        - 방문여부 체크 : boolean[][]
*/

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N][N];

        //그래프 그리기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                graph[i][j] = temp;
                minHeight = Math.min(minHeight, temp);
                maxHeight = Math.max(maxHeight, temp);
            }

        }

        //최소 높이 ~ 최대 높이 사이에서 dfs 탐색
        for (int i = minHeight - 1; i < maxHeight + 1; i++) {

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {

                    if (!visited[a][b] && graph[a][b] > i) {
                        dfs(b, a, i);
                        count += 1;
                    }

                }
            }

            maxNum = Math.max(maxNum, count);
            visited = new boolean[N][N];
            count = 0;

        }


        System.out.println(maxNum);
    }

    //x가 열, y가 행
    public static void dfs(int x, int y, int height) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[ny][nx] && graph[ny][nx] > height) {
                dfs(nx, ny, height);
            }

        }

    }


}