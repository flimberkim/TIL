import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    String word = input.readLine();
    int index = Integer.parseInt(input.readLine());

    System.out.println(word.charAt(index - 1));

  }
}
