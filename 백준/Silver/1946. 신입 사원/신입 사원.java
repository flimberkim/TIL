import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        int memberNum = 0;
        StringBuilder sb = new StringBuilder();
        int prevInterviewRank = 0;

        for(int i = 0; i < testCase; i++){
            memberNum = Integer.parseInt(input.readLine());
            int[] arr = new int[memberNum]; //지원자 수 크기의 배열 생성
            int result = 1; //서류점수 1등은 무조건 합격하기 때문에

            if(memberNum == 1){  //지원자가 1명이라면 해당 케이스는 끝
                sb.append(result).append("\n");
                continue;
            }

            for(int j = 0; j < memberNum; j++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                arr[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken()); //서류점수를 인덱스로 하여, 일차원 배열에는 서류점수 기준으로 정렬된 면접점수가 들어감
            }

            prevInterviewRank = arr[0]; //서류 점수 순으로 정렬했기 때문에, 면접점수만 자기 앞 사람 보다 높으면 합격
            for(int k = 1; k < memberNum; k++){
                if(prevInterviewRank > arr[k]){ //서류점수가 자기보다 높은 앞사람보다 면접 등수가 좋다면,
                    prevInterviewRank = arr[k]; //prevInterviewRank 값 수정해주고
                    result++; //합격인원 +1
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }
}