import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine();

        for (char c : input.toCharArray()) {
            System.out.print((int) c);
        }
    }
}