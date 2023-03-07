import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static int[] arr;
    public static int num;
    public static int count = 0;

    public static void queenProblem(int depth){
        if(depth == num){
            count++;
            return;
        }

        for(int i = 0; i < num; i++){
            arr[depth] = i;
            if(check(depth)){
                queenProblem(depth+1);
            }
        }
    }

    public static boolean check(int colNum){
        
        for(int i = 0; i < colNum; i++){
            if(arr[colNum] == arr[i]){
                return false;
            }
            
            else if(Math.abs(colNum - i) == Math.abs(arr[colNum] - arr[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(input.readLine());
        arr = new int[num];

        queenProblem(0);
        System.out.println(count);

    }

}
