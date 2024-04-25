import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        // 배열 초기화
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int temp;

            temp = arr[a-1];
            arr[a-1] = arr[b-1];
            arr[b-1] = temp;

        }

        for(int i = 0; i < n; i++){
            sb.append(arr[i] + " ");
        }

        System.out.println(sb.toString());

    }
}
