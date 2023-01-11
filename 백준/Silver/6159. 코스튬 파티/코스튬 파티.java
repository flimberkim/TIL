import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int cowNum = Integer.parseInt(st.nextToken());
        int sizeOfCostume = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] cowSizes = new int[cowNum]; //소의 수 크기의 배열 생성

        for(int i = 0; i < cowSizes.length; i++){ //소 사이즈 입력
            cowSizes[i] = Integer.parseInt(input.readLine());
        }

        for(int i = 0; i <= cowSizes.length -2; i++){ //소 두마리의 합이 코스튬 크기 이하인지 확인
            for(int j = i + 1; j < cowSizes.length; j++){
                if(cowSizes[i] + cowSizes[j] <= sizeOfCostume) count++;
            }
        }

        System.out.println(count);
    }
}