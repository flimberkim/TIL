import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int binarySearch(int[] arr, int find){ //이진탐색 메서드 구현

        int first = 0; //배열의 첫번째 인덱스
        int last = arr.length - 1; //배열의 마지막 인덱스

        while(first <= last){

            int mid = (first + last) / 2; // 중간위치의 인덱스

            if(find < arr[mid]){
                last = mid -1;
            }
            else if(find > arr[mid]){
                first = mid + 1;
            }
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] arr1;
        int num = 0;
        int temp = 0;


        num = Integer.parseInt(input.readLine()); //처음 입력 받을 수의 개수
        arr1 = new int[num];
        st = new StringTokenizer(input.readLine());
        for (int j = 0; j < num; j++) { //처음 입력 받은 수들을 arr1에 저장
            arr1[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);


        num = Integer.parseInt(input.readLine()); //두번째 입력 받을 수의 개수

        st = new StringTokenizer(input.readLine());
        for (int j = 0; j < num; j++) { //두번째 입력 받은 수들을 바로 비교해서 처리
            temp = Integer.parseInt(st.nextToken());
            if(binarySearch(arr1, temp) >= 0){
                sb.append(1);
                sb.append("\n");
            }
            else{
                sb.append(0);
                sb.append("\n");
            }
        }

        System.out.println(sb); //최종결과인 sb 출력

    }
}