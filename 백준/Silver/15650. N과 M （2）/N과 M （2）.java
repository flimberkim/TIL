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
        1. 아이디어 : 1부터 N까지 돌면서 크기가 M인 배열에 수열을 저장하는 백트래킹 메서드를 만들어서 문제를 해결한다.
        2. 시간복잡도 : O(N!), N은 주어진 자연수의 크기
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
            backTracking(i + 1, length + 1, result);
        }

    }


}