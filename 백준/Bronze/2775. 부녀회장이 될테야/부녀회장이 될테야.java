import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(st.nextToken());
        int floor = 0;
        int houseNum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int[][] entire = new int[15][15];
        for(int i = 0; i < 15; i++){
            entire[i][1] = 1;
            entire[0][i] = i;
        }

        for(int i = 1; i < 15; i++){
            for(int j = 2; j < 15; j++){
                entire[i][j] = entire[i][j-1]+entire[i-1][j];
            }
        }

        for(int i = 0; i < num; i++){
            floor = Integer.parseInt(input.readLine());
            houseNum = Integer.parseInt(input.readLine());
            result.add(entire[floor][houseNum]);
        }

        for(int i : result){
            System.out.println(i);
        }

    }
}