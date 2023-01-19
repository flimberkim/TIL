import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(st.nextToken());
        int[] arr = new int[num];
        int target = Integer.parseInt(st.nextToken());
        int firstPoint = 0;
        int secondPoint = 0;
        int sum = 0;
        int maxValue = Integer.MIN_VALUE;

        st = new StringTokenizer(input.readLine());

        for(int i = 0; i < num; i++){ //배열에 구멍의 크기들을 입력
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(secondPoint < num){ 
            //총합에 두번째 포인터에 있는 값을 더했을 때 target 이하이면
            if(sum + arr[secondPoint] <= target){
                sum += arr[secondPoint++]; //총합에 그 값 더하고 포인터 이동
                maxValue = Math.max(maxValue, sum); //maxValue에는 target이하 중 최대값을 넣는다.
            }
            else sum -= arr[firstPoint++]; //총합이 target보다 크다면 첫째 포인터 값을 빼고 포인터 이동
        }

        System.out.println(maxValue);

    }
}