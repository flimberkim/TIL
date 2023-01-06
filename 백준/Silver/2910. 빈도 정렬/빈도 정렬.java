import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>(); //각 숫자와 그 수의 빈도수를 담는다.
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int msgLength = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[msgLength];
        int tempArr = 0;
        int tempMap = 0;


        st = new StringTokenizer(input.readLine());

        for(int i = 0; i < arr.length; i++){ //입력받은 숫자와 그 개수를 해시맵에 담는 로직
            tempArr = Integer.parseInt(st.nextToken());
            arr[i] = tempArr;
            if(map.containsKey(tempArr)){
                tempMap = map.get(tempArr) + 1;
                map.put(tempArr, tempMap);
            }
            else{
                map.put(tempArr, 1);
            }
        }

        int[][] arr2 = new int[map.size()][2];
        int t = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){ //해시맵에 담긴 숫자와 개수를 2차원 배열에 넣기
            arr2[t][0] = entry.getKey();
            arr2[t][1] = entry.getValue();
            t++;
        }

        Arrays.sort(arr2, new Comparator<int[]>() { //2차원 배열을 개수 기준으로 내림차순 정렬. 개수가 같다면 그 숫자가 나온 인덱스 값을 비교해서 먼저 나온 순으로 정렬 
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return (Arrays.asList(arr).indexOf(o1[0]) - Arrays.asList(arr).indexOf(o2[0]));
                }
                else return -(o1[1] - o2[1]);
            }
        });

        for(int j = 0; j < map.size(); j++) { //2차원 배열을 차례대로 탐색하면서 처음 입력한 배열에서 같은 값들을 StringBuilder에 추가
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == arr2[j][0]){
                    sb.append(arr[i]).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}