# 백준 문제풀이

## 문제 1193번
### 문제<br>무한히 큰 배열에 다음과 같이 분수들이 적혀있다.<br>1/1	1/2	1/3	1/4	1/5	…<br>2/1	2/2	2/3	2/4	…	…<br>3/1	3/2	3/3	…	…	…<br>4/1	4/2	…	…	…	…<br>5/1	…	…	…	…	…<br>…	…	…	…	…	…<br>이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.<br>X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.<br>입력 :<br>첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.<br>출력 :<br>첫째 줄에 분수를 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>
import java.util.StringTokenizer;<br>

public class PracticeJava {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(st.nextToken());
        int mother = 0; //분모
        int child = 0; //분자
        int temp = 0; //몇 군인지
        int position = 0; //다음 군의 몇 번째인지

        while(true) {
            if ((temp) * (temp + 1) <= num * 2) {
                temp++;
                if((temp) * (temp + 1) > num * 2){
                    temp--;
                    break;
                }
            }
        }


        position = num - ((temp)*(temp+1) / 2);
        if(position == 0){
            if(temp % 2 != 0){
                mother = temp;
                child = 1;
                System.out.println(child + "/" + mother);
            }
            else{
                mother = 1;
                child = temp;
                System.out.println(child + "/" + mother);
            }
        }
        else{
            if(temp % 2 != 0){
                mother = (temp + 1) - (position - 1);
                child = (temp + 2) - mother;
                System.out.println(child + "/" + mother);
            }
            else{
                mother = position;
                child = (temp + 2) - mother;
                System.out.println(child + "/" + mother);
            }
        }
    }
}<br>

### 군수열을 이용해 문제를 풀었는데, 구글링을 해봐도 이렇게 푼 사람이 없는 것 같았다. 주어진 시간 안에 동작하고 문제 맞았다고 뜨긴 했는데, 다른 사람들의 코드보다 길다. 수학을 활용하는게 더 어렵게 푸는건가...? 헷갈린다ㅠㅠ