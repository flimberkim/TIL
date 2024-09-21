import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> searchList = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static int row;
    static int col;
    static int numOfCabbage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : 입력받은 대로 그래프를 그리고 그래프를 돌면서 1을 만날때 마다 BFS로 탐색해서 배추 군락지의 개수를 저장한다.
        2. 시간복잡도 : O(N) , N은 graph의 크기 (행x열)
        3. 자료구조
        - 그래프 전체 지도 : int[][]
        - 방문여부 체크 : boolean[][]
*/

        StringTokenizer st = new StringTokenizer(br.readLine());
        int caseNum = Integer.parseInt(st.nextToken());
        int positionX, positionY;

        for (int i = 0; i < caseNum; i++) {

            st = new StringTokenizer(br.readLine());

            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            graph = new int[row][col];
            visited = new boolean[row][col];
            numOfCabbage = Integer.parseInt(st.nextToken());

            for (int j = 0; j < numOfCabbage; j++) {
                st = new StringTokenizer(br.readLine());
                positionX = Integer.parseInt(st.nextToken());
                positionY = Integer.parseInt(st.nextToken());

                graph[positionY][positionX] = 1;

            }

            //graph를 돌면서 1을 만날 때마다 BFS 탐색 후 sb에 정답 추가
            for (int a = 0; a < row; a++) {
                for (int b = 0; b < col; b++) {
                    if (graph[a][b] == 1) {
                        BFS(b, a);
                    }
                }
            }
            sb.append(count).append("\n");
            count = 0;

        }

        System.out.println(sb.toString().trim());

    }

    //x가 열, y가 행
    //1의 위치를 넘겨 받으면, 거기서부터 배추의 군락지를 탐색한다.
    public static void BFS(int x, int y) {
        if (graph[y][x] == 1 && !visited[y][x]) {
            visited[y][x] = true;
            searchList.add(new int[]{y, x});
            count += 1;
        }

        while (!searchList.isEmpty()) {
            int[] position = searchList.poll();

            for (int i = 0; i < 4; i++) {
                int ny = position[0] + dy[i];
                int nx = position[1] + dx[i];

                if (0 <= ny && ny < row && 0 <= nx && nx < col) {
                    if (graph[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        searchList.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

}