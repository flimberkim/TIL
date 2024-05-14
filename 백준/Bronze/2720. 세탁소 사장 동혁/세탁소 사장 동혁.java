import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int quarter = 25;
    int dime = 10;
    int nickel = 5;
    int penny = 1;

    int caseNum = Integer.parseInt(input.readLine());

    for (int i = 0; i < caseNum; i++) {
      int change = Integer.parseInt(input.readLine());
      sb.append(change / quarter).append(" ");
      change %= quarter;
      sb.append(change / dime).append(" ");
      change %= dime;
      sb.append(change / nickel).append(" ");
      change %= nickel;
      sb.append(change / penny).append("\n");
    }

    System.out.println(sb);
  }
}
