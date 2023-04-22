import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());

        for(int i = 0; i < a; i++){
            for(int j = 0; j < i+1; j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
