import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        int size = Integer.parseInt(input.readLine());
        int minValue = Integer.MAX_VALUE;
        int needNum = 4;
        int temp = 0;

        for(int i = 0; i < size; i++){
            arr.add(Integer.parseInt(input.readLine()));
        }
        arr.sort(Comparator.naturalOrder());

        for(int i = 0; i < arr.size(); i++){
            temp = arr.get(i);
            needNum = 4;
            if(arr.contains(Integer.valueOf(temp+1))) {
                needNum -= 1;
            }
            if(arr.contains(Integer.valueOf(temp+2))) {
                needNum -= 1;
            }
            if(arr.contains(Integer.valueOf(temp+3))) {
                needNum -= 1;
            }
            if(arr.contains(Integer.valueOf(temp+4))) {
                needNum -= 1;
            }
            if(needNum == 0){
                System.out.println(0);
                return;
            }
            else{
                minValue = Math.min(minValue, needNum);
            }
        }
        System.out.println(minValue);
    }
}