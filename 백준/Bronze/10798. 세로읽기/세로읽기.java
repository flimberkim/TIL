import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int maxLen = -1;
    String[] inputWords = new String[5];

    for (int i = 0; i < 5; i++) {
      inputWords[i] = input.readLine();
      maxLen = Math.max(maxLen, inputWords[i].length());
    }

    char[][] words = new char[5][maxLen];

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < maxLen; j++) {
        if (j < inputWords[i].length()) {
          words[i][j] = inputWords[i].charAt(j);
        } else {
          words[i][j] = ' ';
        }
      }
    }
    for (int i = 0; i < maxLen; i++) {
      for (int j = 0; j < 5; j++) {
        if (words[j][i] != ' ') {
          sb.append(words[j][i]);
        }
      }
    }

    System.out.println(sb);

  }
}
