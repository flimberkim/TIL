//시간복잡도 : O(NlogN), N은 가지고 있는 카드의 개수
//아이디어 : 가지고 있는 카드를 입력받아 배열에 넣고 정렬한다. 그리고 확인할 카드를 반복문으로 돌면서 배열에서 찾고 개수를 센다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int cardNum = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int[] cards = new int[cardNum];

        for (int i = 0; i < cardNum; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int givenCardNum = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        int[] givenCards = new int[givenCardNum];

        for (int i = 0; i < givenCardNum; i++) {
            givenCards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        for (int targetNum : givenCards) {
            int firstOccurrence = findFirstOccurrence(cards, targetNum);
            int lastOccurrence = findLastOccurrence(cards, targetNum);

            if (firstOccurrence == -1) {
                sb.append(0).append(" ");
            } else {
                int count = lastOccurrence - firstOccurrence + 1;
                sb.append(count).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching on the left side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching on the right side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

