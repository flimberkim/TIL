import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        int row = 0;
        int col = 0;
        int[][] results = new int[num+1][2];

        results[row][col] = 1;
        results[row][col + 1] = 0;

        while(row < num){ //2차원 행렬을 만들어서 규칙성을 찾아서 구현!
            row++;
            results[row][col + 1] = results[row-1][col] + results[row-1][col+1];
            results[row][col] = results[row -1][col + 1];
        }

        sb.append(results[num][0]); //마지막행 첫번째 열이 A의 개수
        sb.append(" ");
        sb.append(results[num][1]); //마지막행 두번째 열이 B의 개수

        System.out.println(sb);
    }
}