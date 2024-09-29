import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] diagonalX = {1, 1, -1, -1};
    static int[] diagonalY = {1, -1, 1, -1};
    static int row;
    static int col;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : 입력 받은 대로 그래프를 그리고, 각 경우마다 dfs 탐색을 통해 섬의 개수를 구해서 StringBuilder에 저장하고 마지막에 한번에 출력한다.
        2. 시간복잡도 : O(N), N은 행렬의 크기(행*열)
        3. 자료구조
        - 그래프 전체 지도 : int[][]
        - 방문여부 체크 : boolean[][]
*/

        StringTokenizer st;

        String endSign = "0 0";
        String check;

        //종료 조건을 만나기 전까지 반복
        while (true) {
            check = br.readLine();
            if (check.equals(endSign)) {
                break;
            }

            st = new StringTokenizer(check);
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());

            graph = new int[row][col];
            visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visited[i][j] && graph[i][j] != 0) {
                        dfs(j, i);
                        count += 1;
                    }
                }
            }

            sb.append(count).append("\n");
            count = 0;
        }

        System.out.println(sb.toString().trim());
    }

    //x가 열, y가 행
    public static void dfs(int x, int y) {

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int diaX = x + diagonalX[i];
            int diaY = y + diagonalY[i];

            if (0 <= nx && nx < col && 0 <= ny && ny < row && !visited[ny][nx] && graph[ny][nx] != 0) {
                dfs(nx, ny);
            }

            if (0 <= diaX && diaX < col && 0 <= diaY && diaY < row && !visited[diaY][diaX] && graph[diaY][diaX] != 0) {
                dfs(diaX, diaY);
            }
        }

    }


}