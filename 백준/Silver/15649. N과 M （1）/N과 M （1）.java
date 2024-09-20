import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] given;
    static boolean[] visited;
    static int N;
    static int M;
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : 주어진 배열을 돌면서 백트래킹으로 조건에 맞는 수열들을 출력한다.
        2. 시간복잡도 : N!
        3. 자료구조
        - 주어진 숫자 저장 : 배열 
        - 방문여부 체크 : 배열
*/

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        given = IntStream.rangeClosed(1, N).toArray();
        visited = new boolean[N + 1];

        backTracking(0);

        System.out.println(sb.toString());

    }

    public static void backTracking(int depth) {
        if (depth == M) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < given.length; i++) {
            if (!visited[given[i]]) {
                visited[given[i]] = true;
                arr.add(given[i]);
                backTracking(depth + 1);
                visited[given[i]] = false;
                arr.remove(arr.size() - 1);
            }
        }
    }
}