import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : 1부터 N까지 반복문을 돌면서 재귀로 백트래킹 메서드를 호출한다. 구한 수열을 StringBuilder에 저장하고 마지막에 한번에 출력한다.
        2. 시간복잡도 : O(N^2) , N은 입력받은 수의 크기
        3. 자료구조 : 배열
*/

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backTracking(1, 0, new int[M]);

        System.out.println(sb.toString().trim());

    }

    public static void backTracking(int start, int length, int[] result) {
        if (length == M) {

            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i <= N; i++) {
            result[length] = i;
            backTracking(i, length + 1, result);
        }

    }


}