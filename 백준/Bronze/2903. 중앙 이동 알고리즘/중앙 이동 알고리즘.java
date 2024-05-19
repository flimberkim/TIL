import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());

    int dotsInOneLine = 0;
    int lineNum = 0;

    dotsInOneLine = 2 + ((int) Math.pow(2, N) - 1);
    lineNum = (int) Math.pow(2, N) + 1;

    System.out.println(dotsInOneLine * lineNum);
  }
}
