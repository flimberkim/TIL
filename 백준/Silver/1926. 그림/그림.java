import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int numOfDrawing = 0;
    static int maxSize = 0;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
/*
        1. 아이디어 : 2중 for 문을 돌면서 값이 1이면서 방문하지 않은 곳을 대상으로 BFS 탐색
        BFS 돌면서 그림 개수 + 1을 해주며 최대값을 갱신해준다.
        2. 시간복잡도 : O(V+E) , V = 행렬의 크기(mn), E는 평균적으로 하나당 상하좌우 4개의 경우가 있으므로 4V라고 생각
        결국 O(5V) = O(V)
        3. 자료구조
        - 그래프 전체 지도 : int[][]
        - 반문여부 체크 : bool[][]
        - Queue
*/
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] graph = new int[row][col];
        boolean[][] check = new boolean[row][col];

        for (int a = 0; a < row; a++) {
            st = new StringTokenizer(br.readLine());
            for (int b = 0; b < col; b++) {
                graph[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 1 && check[i][j] == false) {
                    //방문 체크
                    //전체 그림 갯수 +1 해준다.
                    //BFS 통해서 그림의 크기를 구해준다.
                    //그림 넓이의 최대값을 갱신
                    check[i][j] = true;
                    numOfDrawing++;
                    maxSize = Math.max(maxSize, bfs(graph, check, i, j));
                }
            }
        }

        System.out.println(numOfDrawing);
        System.out.println(maxSize);

    }

    public static int bfs(int[][] graph, boolean[][] check, int row, int col) {

        queue.offer(new int[]{row, col});

        int area = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= graph.length || ny >= graph[0].length) {
                    continue;
                }
                if (check[nx][ny] == true || graph[nx][ny] != 1) {
                    continue;
                }
                check[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                area++;
            }
        }

        return area;
    }

}