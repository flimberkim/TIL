import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if(minute < 45){
            if(hour != 0){
                hour -= 1;
            }
            else hour = 23;
            minute = 60 +  minute - 45;
        }
        else minute -= 45;

        sb.append(hour).append(" ").append(minute);

        System.out.println(sb);

    }
}