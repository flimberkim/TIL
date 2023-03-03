import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static int[][] arr = new int[9][9];
    static List<int[]> indexOfZero = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


        //입력값 arr에 넣기
        for(int i = 0; i < 9; i++){
            String temp = input.readLine();
            for(int j = 0; j < 9; j++){
                arr[i][j]= Integer.parseInt(String.valueOf(temp.charAt(j)));
                if(arr[i][j] == 0){ //0인 위치의 인덱스 값을 따로 저장해준다.
                    indexOfZero.add(new int[] {i, j});
                }
            }
        }

        backTracking(0);

    }
    private static void print(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    private static void backTracking(int level){
        if(indexOfZero.size() == level){
            print();
            System.exit(0);
        }

        int a = indexOfZero.get(level)[0];
        int b = indexOfZero.get(level)[1];

        boolean[] check = new boolean[10];

        //확인할 인덱스와 같은 행의 요소들 중 사용된 숫자(1~9)를 체크한다.
        for(int i = 0; i < 9; i++){
            if(arr[a][i] != 0){
                check[arr[a][i]] = true;
            }
        }

        //확인할 인덱스와 같은 열의 요소들 중 사용된 숫자(1~9)를 체크한다.
        for(int i = 0; i < 9; i++){
            if(arr[i][b] != 0){
                check[arr[i][b]] = true;
            }
        }

        //확인할 인덱스가 포함된 3*3 크기의 스도쿠 판에서 사용된 숫자를 체크한다.
        int startX = (a/3) * 3;
        int startY = (b/3) * 3;

        for(int i = startX; i < startX + 3; i++){
            for(int j = startY; j < startY + 3; j++){
                if(arr[i][j] != 0){
                    check[arr[i][j]] = true;
                }
            }
        }

        //행, 열, 3*3판에서 사용되지 않은 숫자를 넣는다.
        for(int i = 1; i < 10; i++){
            if(!check[i]){
                arr[a][b] = i;
                backTracking(level + 1);
                arr[a][b] = 0;
            }
        }

    }
}
