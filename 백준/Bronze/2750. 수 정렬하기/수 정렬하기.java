import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] arr =  new int[num];

        for(int i = 0; i < num; i++){ //배열에 값을 입력
            arr[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(arr); //배열 정렬

        for(int i : arr){ //정렬값 출력
            System.out.println(i);
        }

    }
}