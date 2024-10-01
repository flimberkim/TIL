import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
        1. 아이디어 : N개의 자연수를 입력받아 arr에 저장한다. arr을 정렬해 놓은 뒤, 백트래킹을 통해 수열을 생성하고 StringBuilder에 저장해 두었다가 출력한다.
        2. 시간복잡도 : O(N^2) , N은 주어진 자연수의 개수
        3. 자료구조 : 배열
*/

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0, new int[M], new HashSet<>());

        System.out.println(sb.toString().trim());

    }

    public static void backTracking(int length, int[] result, Set<Integer> check) {
        if (length == M) {

            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check.contains(arr[i])) {
                check.add(arr[i]);
                result[length] = arr[i];
                backTracking(length + 1, result, check);
                check.remove(arr[i]);
            }
        }

    }


}