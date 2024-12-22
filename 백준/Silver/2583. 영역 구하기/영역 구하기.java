import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
아이디어 : 먼저 입력 받은 값을 잘 그려주는게 핵심. 그리고 bfs 탐색
시간복잡도 : O(N), N은 이차원 배열 map의 크기
자료구조 : array
*/
public class Main {
    static boolean[][] map;
    static int row;
    static int col;
    static int count = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int area = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new boolean[row][col];

        //지도를 그린다.
        for (int i = 0; i < k; i++) {
            markArea(br.readLine());
        }

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!map[i][j]) {
                    bfs(i, j);
                    arr.add(area);
                    count++;
                    area = 0;
                }
            }
        }

        arr.sort(Comparator.naturalOrder());
        sb.append(count).append("\n");

        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    public static void bfs(int i, int j) {
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1 || map[i][j]) {
            return;
        }

        area++;
        map[i][j] = true;

        for (int a = 0; a < 4; a++) {
            int x = i + dx[a];
            int y = j + dy[a];

            if (x < 0 || x > row - 1 || y < 0 || y > col - 1 || !map[x][y]) {
                bfs(x, y);
            }
        }

    }

    public static void markArea(String temp) {
        StringTokenizer st = new StringTokenizer(temp);

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int startRow = Math.min(row - 1 - y1, row - y2);
        int startCol = Math.min(x1, x2 - 1);
        int endRow = Math.max(row - 1 - y1, row - y2);
        int endCol = Math.max(x1, x2 - 1);

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                map[i][j] = true;
            }
        }

    }


}