import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = IntStream.range(1, n+1).toArray();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while(a <= b) {
                int temp = arr[a-1];
                arr[a-1] = arr[b-1];
                arr[b-1] = temp;
                a++;
                b--;
            }
        }

        for(int i = 0; i < n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.print(sb);

    }
}
