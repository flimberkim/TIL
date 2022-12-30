import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Integer lengthOfArray = Integer.parseInt(input.readLine());
        Integer[] array = new Integer[lengthOfArray];
        StringTokenizer st = new StringTokenizer(input.readLine());
        Integer find = Integer.parseInt(input.readLine());
        Integer count = 0;

        for(int i = 0; st.hasMoreTokens(); i++){ //입력받은 숫자들을 배열에 넣음
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < array.length; i++){ //배열과 비교해서 개수를 셈
            if(array[i] == find) count++;
        }

        System.out.println(count);

    }
}