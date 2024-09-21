import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int M;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : 입력받은 대로 그래프를 그리고 그래프를 돌면서 방문하지 않은 노드라면 count + 1 해주고 DFS 탐색을 통해 연결된 노드들은 방문처리한다.
        2. 시간복잡도 : O(N) , N은 정점의 수  + 간선의 수
        3. 자료구조
        - 그래프 전체 지도 : List<Integer>[]
        - 방문여부 체크 : boolean[]
*/

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        //그래프 그리기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);

        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                DFS(i);
                count += 1;
            }
        }

        System.out.println(count);

    }

    public static void DFS(int currentNode) {
        visited[currentNode] = true;

        for (int nextNode : graph[currentNode]) {
            if (!visited[nextNode]) {
                DFS(nextNode);
            }
        }

    }

}