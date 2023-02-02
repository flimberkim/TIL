import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];

    }
    static int N, M;
    static int[] selected;

    //Recurrence Function(재귀 함수)
    //만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것
    //아직 M 개를 고르지 않음 => K 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도
    static void rec_func(int k){
        if(k == M + 1){ //다 골랐다면
            //selected[1...M] 배열이 새롭게 탐색된 결과
            for(int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append("\n");
        }
        else{
            for(int candidate = 1; candidate <= N; candidate++){
                selected[k] = candidate;
                //k+1 번 ~ M번을 모두 탐색해야하는 상황
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1);
        System.out.println(sb);
    }
}