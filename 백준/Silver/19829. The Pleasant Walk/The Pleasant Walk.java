import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int houseNum = Integer.parseInt(st.nextToken());
        ArrayList<Integer> houseArr = new ArrayList<>(houseNum);
        int leftPoint = 0;
        int rightPoint = 1;
        int maxValue = 1;
        
        st = new StringTokenizer(input.readLine());

        for(int i = 0; i < houseNum; i++){ //배열에 값 집어넣기
            houseArr.add(Integer.parseInt(st.nextToken()));
        }
        
        int temp = houseArr.get(0);

        while(rightPoint < houseNum){ //오른쪽포인터가 끝까지 갈때까지
            if(temp != houseArr.get(rightPoint)){ //만약 처음시작할때 다음값과 다르다면
                temp = houseArr.get(rightPoint); //temp가 하나 따라오고, 오른쪽포인터 이동
                rightPoint++;
            }
            else{ //만약 값이 같다면
                temp = houseArr.get(rightPoint);
                leftPoint = rightPoint; //왼쪽 포인터가 그 위치로 오고
                rightPoint = leftPoint + 1; //오른쪽 포인터는 그보다 하나 큰 인덱스로 초기화
            }
            maxValue = Math.max(maxValue, rightPoint - leftPoint); //최장길이를 구함
        }
        System.out.println(maxValue);

    }
}