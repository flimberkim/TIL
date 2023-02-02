import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        
        for(int i = 0; i < num; i++){ //값을 입력받음
            st = new StringTokenizer(input.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());

            if(min > max){ //둘 중 작은 수를 min에 저장
                temp = min;
                min = max;
                max = temp;
            }
            
            while(min != max){ //min값과 max값을 비교하면서 2로 나눠가고, 같아지는 순간 케이스 종료
                if(min > max){
                    min /= 2;
                    if(min == max) break;
                }
                else{
                    max /= 2;
                    if(min == max) break;
                }
            }
            sb.append(min*10).append("\n");
        }
        System.out.println(sb);

    }
}