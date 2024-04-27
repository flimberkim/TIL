import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = Arrays.stream(new int[26]).map(i -> i = -1).toArray();

        var input = br.readLine();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            if (arr[input.charAt(i) - 'a'] == -1) {
                arr[input.charAt(i) - 'a'] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);

    }
}