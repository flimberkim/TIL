import java.util.*;
import java.io.*;

/*
아이디어 : 사람과 불에 대해 각각 큐를 생성해서 이동 경로를 체크한다.
시간복잡도 : O(N), N은 map의 크기(가로*세로)
자료구조 : array, queue
*/

public class Main {
    static int buildingWidth;
    static int buildingHeight;
    static String[][] map;
    static Queue<int[]> person;
    static Queue<int[]> fire;
    static int answer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            buildingWidth = Integer.parseInt(st.nextToken());
            buildingHeight = Integer.parseInt(st.nextToken());

            map = new String[buildingHeight][buildingWidth];
            person = new LinkedList<>();
            fire = new LinkedList<>();

            //빌딩의 지도 입력(사람 위치, 불 위치도 입력)
            for (int j = 0; j < buildingHeight; j++) {
                map[j] = br.readLine().split("");

                for (int k = 0; k < buildingWidth; k++) {
                    if (map[j][k].equals("@")) {
                        person.add(new int[]{j, k, 0});
                    }

                    if (map[j][k].equals("*")) {
                        fire.add(new int[]{j, k, 0});
                    }
                }
            }

            answer = 0;
            bfs();

            if (answer == 0) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(answer).append("\n");
            }

        }

        System.out.println(sb.toString());
    }

    public static void bfs() {
        while (!person.isEmpty()) {
            int size = fire.size();

            for (int i = 0; i < size; i++) {
                int[] temp = fire.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = temp[0] + dx[j];
                    int ny = temp[1] + dy[j];

                    if (isPossibleRange(nx, ny) && (map[nx][ny].equals(".") || map[nx][ny].equals("@"))) {
                        map[nx][ny] = "*";
                        fire.add(new int[]{nx, ny, 0});
                    }
                }
            }

            size = person.size();

            for (int k = 0; k < size; k++) {
                int[] temp = person.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = temp[0] + dx[j];
                    int ny = temp[1] + dy[j];

                    if (!isPossibleRange(nx, ny)) {
                        answer = temp[2] + 1;
                        return;
                    }

                    if (map[nx][ny].equals(".")) {
                        map[nx][ny] = "@";
                        person.add(new int[]{nx, ny, temp[2] + 1});
                    }

                }
            }

        }
    }

    public static boolean isPossibleRange(int x, int y) {
        return x >= 0 && x < buildingHeight && y >= 0 && y < buildingWidth;
    }

}