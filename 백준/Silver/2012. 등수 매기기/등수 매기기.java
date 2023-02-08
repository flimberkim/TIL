import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] predictedRank = new int[num];
        long min = 0;
        
        //예상 등수를 배열에 저장
        for(int i = 0; i < num; i++){
            predictedRank[i] = Integer.parseInt(input.readLine());
        }
        //오름차순으로 정렬
        Arrays.sort(predictedRank);
        //예상 등수를 오름차순으로 정렬했으므로, 순차적으로 등수가 정해졌을때가 불만이 최소
        for(int i = 0; i < num; i++){
            min += Math.abs((i+1) - predictedRank[i]);
        }

        System.out.println(min);
    }
}