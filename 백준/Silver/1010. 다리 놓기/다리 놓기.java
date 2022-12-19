import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [][] combinationValue = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        int n = 0;
        int r = 0;

        for(int i = 0; i < testNum; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            r = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            sb.append(combination(n,r));
            sb.append("\n");
        }
        System.out.println(sb);
        
    }
    
    //조합의 성질을 이용한 함수. 수가 기하급수적으로 커지기 때문에 무조건 factorial로 하지 말고,조합의 기본 성질을 이용해야 한다!
    static int combination(int n, int r){

        if(combinationValue[n][r] > 0){
            return combinationValue[n][r];
        }

        if(n == r || r == 0){
            return combinationValue[n][r] = 1;
        }

        return combinationValue[n][r] = combination(n-1, r-1) + combination(n-1,r);

    }
}