import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int firstSize = Integer.parseInt(input.readLine());
        int[] arr1 = new int[firstSize];
        int temp = 0;

        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < firstSize; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int secondSize = Integer.parseInt(input.readLine());

        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < secondSize; i++){
            temp = Integer.parseInt(st.nextToken());

            if(Arrays.binarySearch(arr1, temp) >= 0){
                sb.append(1).append("\n");
            }
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}