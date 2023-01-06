import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int length = Integer.parseInt(st.nextToken());
        int testnum= Integer.parseInt(st.nextToken());
        int count = 0;
        String temp;

        String[] words = new String[length];

        for(int i = 0; i < length; i++){
            words[i] = input.readLine();
        }

        for(int j = 0; j < testnum; j++){
            temp = input.readLine();
            for(int k = 0; k < length; k++){
                if(words[k].equals(temp)) count++;
            }
        }

        System.out.println(count);
    }
}