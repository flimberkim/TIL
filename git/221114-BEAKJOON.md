# 백준 문제풀이

## 문제 2178번
### 문제<br>N×M크기의 배열로 표현되는 미로가 있다.<br>1	0	1	1	1	1<br>1	0	1	0	1	0<br>1	0	1	0	1	1<br>1	1	1	0	1	1<br>미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.<br>위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.<br>입력 : <br>첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.<br>출력 :<br>첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>
import java.util.StringTokenizer;<br>

public class PracticeJava {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int[][] maze = new int[row][column];
        String temp;

        for(int i = 0; i < row; i++){
            temp = input.readLine();
            for(int j = 0; j < column; j++){
                maze[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
    }

    public int shortest(int[][] maze, int row, int column){
        int count = 0;
        int i = 0;
        int j = 0;
        
        return count;
    }
}

