//시간복잡도 : O(N), N은 노드의 개수
//아이디어 : 먼저 입력값을 트리로 만들어주고, dfs를 통해 부모 노드를 찾아낸다.
//자료구조 : 배열, 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 트리 구조 생성
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 입력으로 주어진 노드들 간의 연결 관계를 트리로 저장
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        // 각 노드의 부모를 저장하기 위한 배열
        parents = new int[N + 1];
        // 방문 여부를 체크하기 위한 배열
        visited = new boolean[N + 1];

        // 1번 노드를 루트로하여 DFS로 트리의 부모 찾기
        dfs(1);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb.toString());
    }

    // DFS로 트리의 부모 찾기
    static void dfs(int node) {
        visited[node] = true;

        for (int child : tree[node]) {
            if (!visited[child]) {
                parents[child] = node; // 부모를 저장
                dfs(child);
            }
        }
    }
}