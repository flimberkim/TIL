import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int calc(int num){
        if(num == 1) return 1;
        if(num == 2) return 2;
        if(num == 3) return 4;

        return calc(num - 1) + calc(num -2) + calc(num -3);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(input.readLine());

        for(int i = 0; i < num; i++){
           sb.append(calc(Integer.parseInt(input.readLine()))).append("\n");
        }
        System.out.println(sb);
    }
}