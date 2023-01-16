import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int num = Integer.parseInt(input.readLine());
        int[] arr = new int[num];
        int target = 0;
        int count = 0;

        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < num; i++){ //입력받은 수들을 배열에 넣고
            arr[i] = Integer.parseInt(st.nextToken());
        }

        target = Integer.parseInt(input.readLine());

        Arrays.sort(arr); //배열은 순서대로 정렬
        int minPoint = 0; //첫 인덱스와 끝 인덱스를 각각 포인터로 설정
        int maxPoint = arr.length - 1;

        while(minPoint < maxPoint){
            if(arr[minPoint] + arr[maxPoint] == target) { //타겟넘버와 비교해서 개수 증가 후 포인터 조정
                count++;
                maxPoint--;
            }
            else if(arr[minPoint] + arr[maxPoint] < target){
                minPoint++;
            }
            else maxPoint--;
        }
        System.out.println(count);
    }
}