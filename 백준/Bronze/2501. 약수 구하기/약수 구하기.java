import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int num = Integer.parseInt(st.nextToken());
        int rank = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        int answer = 0;

        for(int i = 1; i <= num; i++){
            if(num % i == 0) arr.add(i);
        }

        try{
            answer = arr.get(rank - 1);
        }
        catch (Exception e){
            answer = 0;
        }

        System.out.println(answer);
    }
}