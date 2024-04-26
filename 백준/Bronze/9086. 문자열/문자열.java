import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(input.readLine());

    for (int i = 0; i < n; i++) {
      String word = input.readLine();

      sb.append(word.charAt(0)).append(word.charAt(word.length() - 1)).append("\n");

    }

    System.out.print(sb);

  }
}
