//시간복잡도 : O(N), N은 주어진 인형의 개수
//아이디어 : 주어진 인형을 저장하는 배열에 대한 포인터와, 1의 위치만 저장한 배열에 대한 포인터를 같이 사용한다.
//        1의 위치만 저장한 배열에 대해 슬라이딩 윈도우로 탐색하면서 조건에 만족할때마다 범위의 최소값을 업데이트한다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int len = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int[] arr = new int[len];
        List<Integer> positions = new ArrayList<>();

        for(int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 1) positions.add(i);
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        if(positions.size() < targetNum) {
            System.out.println(-1);
            return;
        }

        int positionLeftPointer = 0;
        int positionRightPointer = targetNum - 1;
        left = positions.get(positionLeftPointer);
        right = positions.get(positionRightPointer);
        min = Math.min(min, (right - left) + 1);

        while(true) {
            positionLeftPointer++;
            positionRightPointer++;

            left = positions.get(positionLeftPointer);
            if(positionRightPointer < positions.size()){
                right = positions.get(positionRightPointer);
            }
            else {
                break;
            }
            min = Math.min(min, (right - left) + 1);
        }

        System.out.println(min);
    }
}

