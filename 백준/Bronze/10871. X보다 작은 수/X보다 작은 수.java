import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(input.readLine());

        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num < x){
                sb.append(num).append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());
    }
}
