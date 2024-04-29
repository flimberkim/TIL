import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int temp = 0;
    int row = 0;
    int col = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(input.readLine());
      for (int j = 0; j < 9; j++) {
        temp = Integer.parseInt(st.nextToken());
        if (temp > max) {
          max = temp;
          row = i + 1;
          col = j + 1;
        }
      }
    }

    sb.append(max).append("\n").append(row).append(" ").append(col);
    System.out.println(sb);
    
  }
}
