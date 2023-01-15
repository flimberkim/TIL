import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[num];
        int coinNum = 0;
        int temp = 0;

        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder()); //동전을 내림차순으로 배열에 저장

        for(int i = 0; i < num; i++){
            if(price == 0) break; //금액이 0이 되면 끝내기
            if(arr[i] > price) continue; //돈의 단위가 총 금액보다 크면 다음으로 넘어감
            temp = price / arr[i]; //사용할 수 있는 동전의 개수 구하고
            price -= temp*arr[i]; //금액을 빼준 뒤
            coinNum += temp; //사용한 동전의 개수를 count에 추가해준다
        }

        System.out.println(coinNum); //최종적으로 사용된 동전의 개수 출력

    }
}