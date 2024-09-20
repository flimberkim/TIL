import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] graph;
    static int answer = Integer.MAX_VALUE;
    static Queue<int[]> searchList = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : 입력받은대로 미로를 생성하고, 각 위치에서 갈 수 있는 점을 BFS로 탐색하며 그 때마다 count 수를 함께 저장한다.
        2. 시간복잡도 : O(N), N은 미로에서 이동할 수 있는 노드의 개수
        3. 자료구조
        - 미로 지도 : int[][]
        - 방문여부 체크 : boolean[][]
*/

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        //입력받은대로 미로 생성
        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(temp[j]));
            }
        }

        BFS(0, 0);

        System.out.println(answer);
    }

    //x가 열, y가 행
    public static void BFS(int startX, int startY) {
        int[] tempArr = {startY, startX, 1};
        searchList.add(tempArr);
        visited[startY][startX] = true;

        while (!searchList.isEmpty()) {

            int[] currentPosition = searchList.poll();

            int currentY = currentPosition[0];
            int currentX = currentPosition[1];
            int currentCount = currentPosition[2];

            if (currentY == N - 1 && currentX == M - 1) {
                answer = Math.min(answer, currentCount);
            }

            for (int i = 0; i < 4; i++) {
                int ny = currentY + dy[i];
                int nx = currentX + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M) {

                    if (!visited[ny][nx] && graph[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        int[] temp = {ny, nx, currentCount + 1};
                        searchList.add(temp);
                    }

                }

            }

        }
    }

}