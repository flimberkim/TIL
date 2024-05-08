import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    boolean[][] check = new boolean[100][100];
    int n = Integer.parseInt(input.readLine());
    int answer = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      for (int j = x; j < x + 10; j++) {
        for (int k = y; k < y + 10; k++) {
          check[j][k] = true;
        }
      }
    }

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (check[i][j]) {
          answer++;
        }
      }
    }

    System.out.println(answer);

  }
}
