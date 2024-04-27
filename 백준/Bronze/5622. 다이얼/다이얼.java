import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        var input = br.readLine();
        int length = input.length();

        int totalTime = 0;

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == 'A' || c == 'B' || c == 'C') {
                totalTime += 3;
            } else if (c == 'D' || c == 'E' || c == 'F') {
                totalTime += 4;
            } else if (c == 'G' || c == 'H' || c == 'I') {
                totalTime += 5;
            } else if (c == 'J' || c == 'K' || c == 'L') {
                totalTime += 6;
            } else if (c == 'M' || c == 'N' || c == 'O') {
                totalTime += 7;
            } else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
                totalTime += 8;
            } else if (c == 'T' || c == 'U' || c == 'V') {
                totalTime += 9;
            } else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
                totalTime += 10;
            }
        }
        System.out.println(totalTime);
    }
}