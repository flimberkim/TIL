import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] temp1;
        int[][] temp2;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        temp1 = new int[a][b];
        temp2 = new int[a][b];

        for(int i = 0; i < a; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < b; j++){
                temp1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < a; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < b; j++){
                temp2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                sb.append(temp1[i][j] + temp2[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
