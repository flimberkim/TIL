import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String word = input.readLine();
    String reverse = new StringBuilder(word).reverse().toString();

    if (word.equals(reverse)) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }

  }
}
