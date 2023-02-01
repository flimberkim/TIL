import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int temp = 0;

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(input.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());

            if(min > max){
                temp = min;
                min = max;
                max = temp;
            }
            
            while(min != max){
                if(min > max){
                    min /= 2;
                    if(min == max) break;
                }
                else{
                    max /= 2;
                    if(min == max) break;
                }
            }
            sb.append(min*10).append("\n");
        }
        System.out.println(sb);

    }
}