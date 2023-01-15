import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(st.nextToken());
        int needNum = Integer.parseInt(st.nextToken());
        int brokenNum = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int[] trafficLights = new int[num + 1];
        int temp = 0;

        Arrays.fill(trafficLights, -1);  //정상이 -1, 망가진 신호등이 0

        for(int i = 0; i < brokenNum; i++){ //망가진 신호등을 해당 위치에 입력
            trafficLights[Integer.parseInt(input.readLine())] = 0;
        }

        for(int i = 1; i <= num + 1 - needNum; i++){ //필요한 길이에서 망가진 신호등(고쳐야할 신호등)개수 구함
            for(int j = i; j < i + needNum; j++){
                if(trafficLights[j] == 0) temp++;
            }
            tm.put(temp, 0); //그 값을 키로 treemap에 저장
            temp = 0;
        }
        System.out.println(tm.firstKey()); //첫 번째 키 값을 출력
    }
}