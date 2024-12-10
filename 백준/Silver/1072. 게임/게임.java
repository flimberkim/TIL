import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
        1. 아이디어 : 지금까지의 게임 횟수를 반으로 줄여나가면서 추가로 진행해야할 게임의 횟수를 찾는다.(이분탐색)
        2. 시간복잡도 : O(logN), N은 처음 입력 받는 게임의 횟수
        3. 자료구조 : -

*/

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(input.readLine());

    long x = Long.parseLong(st.nextToken()); // 총 게임 횟수
    long y = Long.parseLong(st.nextToken()); // 이긴 게임 횟수

    int z = (int) ((y * 100) / x); // 현재 승률

    // 승률이 이미 99% 이상이면 더 이상 증가 불가능
    if (z >= 99) {
      System.out.println(-1);
      return;
    }

    // 이진 탐색 시작
    long left = 0;
    long right = x;
    long answer = -1;

    while (left <= right) {
      long mid = (left + right) / 2;
      int newZ = (int) (((y + mid) * 100) / (x + mid)); // mid 번 더 승리했을 때의 승률

      if (newZ > z) { // 승률이 증가했다면
        answer = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.println(answer);
  }


}
