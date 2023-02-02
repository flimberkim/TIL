import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int len = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[] bottom = new int[height + 1];
        int[] botSum = new int[height + 1];
        int[] top = new int[height + 1];
        int[] topSum = new int[height + 1];
        int min = Integer.MAX_VALUE; //부수는 장애물의 최소값을 저장할 변수
        int count = 0; //부수는 장애물의 개수
        int secondCount = 0; //부수는 최소개수가 같은 구간의 개수

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len/2; i++){ //각 장애물의 높이에 해당하는 인덱스 값을 증가시킴
            bottom[Integer.parseInt(input.readLine())]++;
            top[Integer.parseInt(input.readLine())]++;
        }

        //누적합 계산
        for(int i = 1; i < height + 1; i++){
            botSum[i] = botSum[i - 1] + bottom[i]; //높이가 i 이하인 석순의 개수
            topSum[i] = topSum[i - 1] + top[i]; //높이가 i 이하인 종유석의 개수
        }

        for(int i = 1; i < height + 1; i++){
            count = 0; //벌레가 부수는 장애물 개수

            count += botSum[height] - botSum[i - 1]; //벌레의 높이가 i일때 부수는 석순은 높이가 i이상인 경우임
            count += topSum[height] - topSum[height - i]; //벌레의 높이가 i일때 부수는 종유석은 높이가 height-i+1 이상인 경우임

            if(min > count){
                min = count; //기존 min값보다 count가 작다면 최소값을 갱신하고
                secondCount = 1; //그 구간이 몇개인지 카운트하기 시작!
            }
            else if(min == count){ //그 구간이 나올때마다 카운트 증가
                secondCount++;
            }
        }
        sb.append(min).append(" ").append(secondCount);
        System.out.println(sb);
    }
}