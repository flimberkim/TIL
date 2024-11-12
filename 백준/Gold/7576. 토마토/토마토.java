import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
아이디어 : 처음 토마토의 정보를 기록하면서 익지 않은 토마토의 개수를 저장해둔다. 
bfs를 돌면서 토마토가 익을 때마다 개수를 감소시켜준다. 
마지막에 남은 개수를 확인하고 그에 따라 결과를 출력한다.
시간복잡도 : O(N), N은 map의 크기(가로*세로)
자료구조 : array, queue
*/
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static int row;
    static int col;

    static int prematuredTomato = 0;
    static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        //토마토 위치 정보를 기록
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < col; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 0) {
                    prematuredTomato++;
                } else if (temp == 1) {
                    queue.add(new int[]{i, j});
                } else {
                    visited[i][j] = true;
                }

                map[i][j] = temp;
            }
        }
        if (prematuredTomato == 0) {
            System.out.println(0);
            return;
        }

        prematuredTomato += queue.size();

        //bfs 탐색
        bfs();

        //결과 출력
        if (prematuredTomato == 0) {
            System.out.println(--days);
        } else {
            System.out.println(-1);
        }

    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            //다음 위치들이 유효한지 체크하기 위한 변수
            int check = 0;

            for (int a = 0; a < size; a++) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];

                if (canGo(x, y)) {
                    check++; //유효 해서 토마토의 개수가 변했을 때만 days를 변화시킨다.
                    visited[x][y] = true;
                    map[x][y] = 1;
                    prematuredTomato--;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (canGo(nx, ny)) {
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            if (check > 0) {
                days++;
            }
        }

    }

    public static boolean canGo(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col && !visited[i][j];
    }

}