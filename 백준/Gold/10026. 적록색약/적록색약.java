import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
        1. 아이디어 : 적록색약인 사람과 아닌 사람을 위한 graph와 방문여부(visited)를 따로 만들고 이를 이용해 DFS 탐색을 진행한다.
        2. 시간복잡도 : O(4*N^2) = O(N^2) , N은 노드의 개수 
        3. 자료구조
        - 그래프 전체 지도 : char[][]
        - 방문여부 체크 : boolean[][]
*/

public class Main {

  static int N;
  static char[][] graphForNormal;
  static boolean[][] visitedForNormal;
  static int countForNormal = 0;
  static char[][] graph;
  static boolean[][] visited;
  static int count = 0;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());

    graphForNormal = new char[N][N];
    graph = new char[N][N];
    visitedForNormal = new boolean[N][N];
    visited = new boolean[N][N];

    char[] temp;

    //그래프 작성
    for (int i = 0; i < N; i++) {
      temp = input.readLine().toCharArray();

      for (int j = 0; j < N; j++) {
        graphForNormal[i][j] = temp[j];  // 정상 시각
        if (temp[j] == 'G') {
          graph[i][j] = 'R';  // 적록색약 시각으로 변환
        } else {
          graph[i][j] = temp[j];  // B는 그대로 복사
        }
      }

    }

    //DFS 탐색
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visitedForNormal[i][j]) {
          visitedForNormal[i][j] = true;
          dfsForNormal(j, i, graphForNormal[i][j]);
          countForNormal += 1;
        }

        if (!visited[i][j]) {
          visited[i][j] = true;
          dfs(j, i, graph[i][j]);
          count += 1;
        }
      }
    }

    //결과 출력
    sb.append(countForNormal).append(" ").append(count);
    System.out.print(sb);

  }

  //x가 열, y가 행
  public static void dfsForNormal(int x, int y, char check) {

    if (graphForNormal[y][x] != check) {
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (0 <= nx && nx < N && 0 <= ny && ny < N) {
        if (!visitedForNormal[ny][nx] && graphForNormal[ny][nx] == check) {
          visitedForNormal[ny][nx] = true;
          dfsForNormal(nx, ny, check);
        }
      }

    }

  }

  public static void dfs(int x, int y, char check) {

    if (graph[y][x] != check) {
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (0 <= nx && nx < N && 0 <= ny && ny < N) {
        if (!visited[ny][nx] && graph[ny][nx] == check) {
          visited[ny][nx] = true;
          dfs(nx, ny, check);
        }
      }

    }

  }


}
