import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(input.readLine());
        int count = 0;

        for(int a = 0; a < testNum; a++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 1; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if ((((i + j) * (i + j)) + m) % (i * j) == 0) count++;
                }
            }
            sb.append(count).append("\n");
            count = 0;
        }

        System.out.println(sb);

    }
}