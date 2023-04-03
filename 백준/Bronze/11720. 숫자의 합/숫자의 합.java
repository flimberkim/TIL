import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int sum = 0;
        String temp;

        temp = bf.readLine();

        for(int i = 0; i < temp.length(); i++){
            sum += Integer.parseInt(String.valueOf(temp.charAt(i)));
        }
        System.out.println(sum);

    }
}
