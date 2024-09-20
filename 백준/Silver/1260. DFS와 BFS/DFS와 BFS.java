import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Queue<Integer> searchList = new LinkedList<>();
    static List<Integer> visited = new ArrayList<>();
    static StringBuilder sbForBFS = new StringBuilder();
    static StringBuilder sbForDFS = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : 입력받은 대로 그래프를 그리고 각각 DFS, BFS로 탐색해서 출력한다. 주의할 점은 그래프를 그릴때 노드의 번호 순으로 그릴 것!
        2. 시간복잡도 : DFS : O(N^2), N은 노드의 개수, BFS : O(N) , N은 노드와 간선의 개수 합
        3. 자료구조
        - 그래프 전체 지도 : Map<Integer, List<Integer>>
        - 방문여부 체크 : Set<Integer>
*/
        int N, M, V;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //노드 개수
        M = Integer.parseInt(st.nextToken()); //엣지 개수
        V = Integer.parseInt(st.nextToken()); //시작 노드 번호

        //그래프 작성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph.computeIfAbsent(num1, k -> new ArrayList<>()).add(num2);
            graph.computeIfAbsent(num2, k -> new ArrayList<>()).add(num1);
        }
        
        // 1부터 N까지 모든 노드가 있는지 확인하고, 없는 경우 빈 리스트 추가
        for (int i = 1; i <= N; i++) {
            graph.computeIfAbsent(i, k -> new ArrayList<>());
        }

        //정렬
        for (List<Integer> neighbors : graph.values()) {
            Collections.sort(neighbors);
        }
        
        if(M == 0){
            System.out.println(V);
            System.out.println(V);
        }
        
        DFS(V);
        for (int num : visited) {
            sbForDFS.append(num).append(" ");
        }

        visited = new ArrayList<>();

        BFS(V);
        for (int num : visited) {
            sbForBFS.append(num).append(" ");
        }

        System.out.println(sbForDFS.toString().trim());
        System.out.println(sbForBFS.toString().trim());
    }

    public static void DFS(int startNum) {
        if (!graph.containsKey(startNum)) {
            return;
        }

        visited.add(startNum);
        List<Integer> temp = graph.get(startNum);

        for (int node : temp) {
            if (!visited.contains(node)) {
                DFS(node);
            }
        }
    }

    public static void BFS(int startNum) {
        if (!graph.containsKey(startNum)) {
            return;
        }

        visited.add(startNum);
        searchList.addAll(graph.get(startNum));

        while (!searchList.isEmpty()) {

            int temp = searchList.poll();

            if (!visited.contains(temp)) {
                visited.add(temp);
                if (graph.containsKey(temp)) {
                    searchList.addAll(graph.get(temp));
                }
            }
        }

    }

}