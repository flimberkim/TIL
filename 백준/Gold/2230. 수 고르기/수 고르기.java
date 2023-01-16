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
        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(arr);

        int firstPoint = 0;  //같은수를 뽑아도 되기 때문에 같은 포인트 두개로 시작!
        int secondPoint = 0;

        while(firstPoint < num){
            if(arr[firstPoint] - arr[secondPoint] < target){ //차이가 더 작다면 첫째 포인터 증가
                firstPoint++;
                continue;
            }
            if(arr[firstPoint] - arr[secondPoint] == target){ //차이가 target과 같다면 바로 끝
                minValue = target;
                break;
            }
            //차이가 target보다 크다면 두번째 포인터를 따라오게 해서 차이를 줄여본다!
            minValue = Math.min(minValue, arr[firstPoint] - arr[secondPoint]);
            secondPoint++;
        }

        System.out.println(minValue); //target과 가장 가까운 값 출력
    }
}