import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();
    static Queue<Integer> toDoList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
/*
        1. 아이디어 : 입력 받은 대로 연결된 컴퓨터들을 Map에 기록하고 BFS를 통해 연결된 컴퓨터의 개수를 파악한다.
        2. 시간복잡도 : O(N), N은 컴퓨터 1과 연결된 모든 컴퓨터의 개수
        3. 자료구조
        - 그래프 전체 지도 : Map<Integer, List<Integer>>
        - 방문여부 체크 : Set<Integer>
*/
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int numOfComputers = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int connectedPairs = Integer.parseInt(st.nextToken());
        int key;
        int value;

        //입력을 받은대로 그래프를 생성, 주의! 양방향으로 연결해야 한다.
        for (int i = 0; i < connectedPairs; i++) {
            st = new StringTokenizer(br.readLine());
            key = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            List<Integer> temp = graph.getOrDefault(key, new ArrayList<>());
            temp.add(value);
            graph.put(key, temp);
            List<Integer> temp1 = graph.getOrDefault(value, new ArrayList<>());
            temp1.add(key);
            graph.put(value, temp1);
        }

        //1번 컴퓨터가 바이러스에 걸리면 함께 감염되는 컴퓨터의 수를 구한다.

        int result;
        if (!graph.containsKey(1)) {
            result = 0;
        } else {
            result = BFS(1);
        }

        System.out.print(result);

    }

    public static int BFS(int current) {

        if (graph.containsKey(current)) {
            List<Integer> temp = graph.get(current);

            toDoList.addAll(temp);

            //1은 방문 목록에 넣어준다.
            visited.add(current);
        }

        int next;

        while (!toDoList.isEmpty()) {
            next = toDoList.poll();
            if (!visited.contains(next)) {
                if (graph.containsKey(next)) {
                    List<Integer> tempNums = graph.get(next);
                    toDoList.addAll(tempNums);
                }
                visited.add(next);
                count++;
            }
        }

        return count;
    }

}