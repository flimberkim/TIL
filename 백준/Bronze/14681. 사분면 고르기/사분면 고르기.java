import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int y = Integer.parseInt(st.nextToken());

        if(x > 0 && y > 0){
            System.out.println(1);
        }
        else if (x < 0 && y > 0){
            System.out.println(2);
        }
        else if (x < 0 && y < 0){
            System.out.println(3);
        }
        else System.out.println(4);
    }

}
