import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
아이디어 : 최빈값만 신경써주면 된다. map에 각 숫자와 출현 횟수를 저장해준다.
마지막에 출현횟수 기준으로 정렬해주고, 최빈값이 여러개 있다면 두번째 숫자를 출력할 수 있도록 한다.
자료구조 : array, map, treeMap
시간복잡도 : O(N), N은 입력받는 숫자의 개수
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int AVG;
        int MID;
        int MFO;
        int RANGE;

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int temp = 0;
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(br.readLine());
            sum += temp;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            arr[i] = temp;
        }

        Arrays.sort(arr);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int index = 0;
        int max = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        max = list.get(index).getValue();
        MFO = list.get(index++).getKey();
        treeMap.put(MFO, 0);

        while (true) {

            if (index > list.size() - 1 || list.get(index).getValue() != max) {
                break;
            }
            treeMap.put(list.get(index++).getKey(), 0);

        }

        if (treeMap.size() > 1) {
            treeMap.remove(treeMap.firstKey());
            MFO = treeMap.firstKey();
        }

        double avg = (double) sum / n;
        AVG = (int) Math.round(avg);
        MID = arr[n / 2];
        RANGE = arr[n - 1] - arr[0];

        sb.append(AVG).append("\n").append(MID).append("\n").append(MFO).append("\n").append(RANGE);

        System.out.println(sb);
    }


}