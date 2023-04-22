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

        for(int i = 1; i <= a; i++){
            for(int j = a - i; j > 0; j--){
                sb.append(" ");
            }
            for(int k = 1; k <= i; k++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
