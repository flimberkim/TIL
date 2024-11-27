import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
        1. 아이디어 : 들어올 차와 나갈 차를 기록한 배열을 돌면서 차가 나가기 전까지는 큐에 담아둔다. 그리고 주차 가능한 공간의 크기만큼만 차를 주차시키고,
        주차 공간이 다 차면 배열(order)의 멈췄던 부분부터 다시 돌면서 차를 빼준다.
        2. 시간복잡도 : O(M)
        3. 자료구조 : array, Queue, PriorityQueue
*/

public class Main {

  static int N;
  static int M;
  static int[] fee;
  static int[] cars;

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    int total = 0;
    Queue<Integer> queue = new LinkedList<>();

    PriorityQueue<Integer> nextParking = new PriorityQueue<>();
    Map<Integer, Integer> map = new HashMap<>();

    StringTokenizer st = new StringTokenizer(input.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    fee = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      fee[i] = Integer.parseInt(input.readLine());
      nextParking.add(i);
    }

    cars = new int[M + 1];

    for (int i = 1; i <= M; i++) {
      cars[i] = Integer.parseInt(input.readLine());
    }

    int[] order = new int[2 * M];
    for (int i = 0; i < 2 * M; i++) {
      order[i] = Integer.parseInt(input.readLine());
    }

    int index = 0;

    int availableParkingLot;

    while (index < 2 * M) {
      int nextCar;

      while (order[index] > 0) {
        queue.add(order[index]);
        index++;
      }

      if (!nextParking.isEmpty()) {
        int size = nextParking.size();
        for (int i = 0; i < size; i++) {
          if (queue.isEmpty()) {
            break;
          }
          nextCar = queue.poll();
          availableParkingLot = nextParking.poll();
          total += fee[availableParkingLot] * cars[nextCar];
          map.put(nextCar, availableParkingLot);
        }
      }

      nextParking.add(map.get(order[index] * (-1)));
      map.remove(order[index++]);

    }

    System.out.print(total);

  }


}
