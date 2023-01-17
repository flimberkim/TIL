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
        int minValue = Integer.MAX_VALUE;

        st = new StringTokenizer(input.readLine());

        for(int i = 0; i < num; i++){ //배열에 수를 입력
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //시작은 두 포인터 모두 0부터 시작
        while(secondPoint <= num){

            if(sum >= target){ //만약 합이 target보다 크다면 첫번째 포인터에 해당하는 수를 빼고, 포인터 한칸 이동
                sum -= arr[firstPoint++];
                minValue = Math.min(minValue, secondPoint - firstPoint + 1); //길이의 최소값을 minValue에 저장
            }
            else if(sum < target && secondPoint == num) break; //마지막 숫자가 포함될 경우를 위한 조건
            else sum += arr[secondPoint++]; //합이 target보다 작다면 합에 숫자를 더하고 두번째 인덱스 위치 증가
        }
        //minValue 값이 초기값 그대로라면 조건에 해당하는 수열이 없는것.
        if(minValue == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minValue);

    }
}