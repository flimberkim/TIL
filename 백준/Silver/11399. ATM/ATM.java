import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int temp = num;
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] arr = new int[num];
        int min = 0;
        
        //먼저 한 사람당 걸리는 시간을 입력받아 배열에 저장
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //배열을 오름차순으로 정렬
        Arrays.sort(arr);
        
        //결국 가장 작은 값은 사람 수 만큼 더해지고, 그 다음 작은 값은 사람수 -1, 그 다음 작은 값은 사람수 -2 ...이런 방식으로 더해진다.
        //수식으로 표현에서 min에 저장 후 출력
        for(int i = 0; i < num; i++){
            min += arr[i] * temp--;
        }

        System.out.println(min);
    }
}