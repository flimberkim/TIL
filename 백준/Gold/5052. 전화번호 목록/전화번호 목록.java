//시간복잡도 : O(NlonN), N은 케이스 당 입력받는 단어의 개수 
//아이디어 : 입력받은 단어들을 오름차순 정렬한다. 오름차순 정렬 했기 때문에 만약 접두어라면 바로 다음 단어의 접두어가 된다.
//          즉, 다음 단어하고만 계속 비교해나가면 된다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();


        int caseNum = Integer.parseInt(st.nextToken());

        while(caseNum-- > 0){
            int num = Integer.parseInt(input.readLine());
            String[] arr = new String[num];

            for(int i = 0; i < num; i++){
                arr[i] = input.readLine();
            }
            Arrays.sort(arr);

            if(check(num, arr)) {
                sb.append("YES").append("\n");
            }
            else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean check(int num, String[] arr){
        for(int i = 0; i < num - 1; i++){
            if(arr[i + 1].startsWith(arr[i])){
                return false;
            }
        }
        return true;
    }
}