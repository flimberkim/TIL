import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Set<Character> check = new HashSet<>();
    static int row;
    static int col;
    static int count = 1;
    static int maxNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : 입력 받은대로 그래프를 그리고, 방문 여부를 체크할 visited와 지나간 문자인지 확인할 HashSet을 생성해서 dfs 탐색하며 움직인 최대 칸 수를 업데이트한다.
        2. 시간복잡도 : O(N), N은 graph의 크기(행*열)
        3. 자료구조
        - 그래프 전체 지도 : char[][]
        - 방문여부 체크 : boolean[][]
*/

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        graph = new char[row][col];
        visited = new boolean[row][col];

        //그래프 작성
        for (int i = 0; i < row; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        //dfs 탐색
        check.add(graph[0][0]);
        dfs(0, 0, 1);
        System.out.print(maxNum);

    }

    //x 가 열, y 가 행
    public static void dfs(int x, int y, int count) {

        maxNum = Math.max(maxNum, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny)) {
                check.add(graph[ny][nx]);
                dfs(nx, ny, count + 1);
                check.remove(graph[ny][nx]);
            }

        }

    }

    public static boolean canGo(int x, int y) {

        return 0 <= x && x < col && 0 <= y && y < row && !visited[y][x] && !check.contains(graph[y][x]);

    }

}