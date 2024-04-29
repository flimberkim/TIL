import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String score;
    double total = 0;
    double credit = 0;
    double creditSum = 0;

    Map<String, Double> map = Map.of("A+", 4.5, "A0", 4.0, "B+", 3.5, "B0", 3.0, "C+", 2.5, "C0",
      2.0, "D+", 1.5, "D0", 1.0, "F", 0.0);

    for (int i = 0; i < 20; i++) {
      st = new StringTokenizer(input.readLine());
      st.nextToken();
      credit = Double.parseDouble(st.nextToken());
      score = st.nextToken();

      if (map.containsKey(score)) {
        total += map.get(score) * credit;
        creditSum += credit;
      }
    }

    System.out.println(total / creditSum);

  }
}
