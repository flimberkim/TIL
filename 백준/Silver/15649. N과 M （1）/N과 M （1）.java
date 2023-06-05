import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    public static int[] arr;
    public static boolean[] check;
    public static StringBuilder sb = new StringBuilder();

    public static void backtracking(int N, int M, int depth){
        if(depth == M){
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!check[i]){
                check[i] = true;
                arr[depth] = i;
                backtracking(N, M, depth+1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 아이디어 : 백트래킹 재귀함수 안에서 for문 돌면서 숫자 선택(선택 여부 확인)
        //2. 시간복잡도 : N!
        //3. 자료구조 : 배열
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        check = new boolean[N+1];
        backtracking(N, M, 0);
        System.out.println(sb);
    }
}
