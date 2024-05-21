import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Deque<Integer> deque = IntStream.rangeClosed(1, n)
      .collect(LinkedList::new, Deque::add, Deque::addAll);

    int count = 1;
    sb.append("<");
    while (!deque.isEmpty()) {
      if (count == k) {
        sb.append(deque.pollFirst()).append(", ");
        count = 1;
      } else {
        deque.addLast(deque.pollFirst());
        count++;
      }
    }
    sb.setLength(sb.length() - 2);
    sb.append(">");

    System.out.println(sb);

  }
}
