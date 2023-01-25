import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int treeNum = Integer.parseInt(st.nextToken());
        int needLen = Integer.parseInt(st.nextToken());
        int[] treeHeights = new int[treeNum];
        st = new StringTokenizer(input.readLine());
        int min = 0;
        int max = 0;

        for(int i = 0; i < treeNum; i++){ //배열에 나무의 높이들을 넣으면서 제일 높은 나무의 높이를 max에 저장
            treeHeights[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, treeHeights[i]);
        }

        while(min < max){
            int mid = (min + max) / 2; //계속 max와 min의 중간값으로 비교를 한다!
            long sum = 0;
            for(int treeHeight : treeHeights){
                if(treeHeight - mid > 0){ //나무 높이가 중간값보다 클 경우에만 잘리는 길이를 sum에 더함
                    sum += (treeHeight - mid);
                }
            }

            if(sum < needLen){ //잘린 나무의 길이의 합이 필요한 길이보다 작다면
                max = mid; //제일 높은 길이를 중간값으로 내림
            }
            else{ //아니면 최소값을 중간값보다 1늘려서 재설정
                min = mid + 1;
            }
        }
        System.out.println(min - 1); //값이 역전되는 min값에서 1작은 값으로 출력.
    }
}