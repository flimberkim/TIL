# 백준 문제풀이

## 문제 2309번
### 문제<br>
왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.<br>아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.<br>아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.<br><br>
입력 :<br>아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.<br><br>
출력 :<br>일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>
import java.util.Arrays;<br>

public class PracticeJava {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] candidates = new int[9];
        int sum = 0;

        for(int i = 0; i < candidates.length; i++){
            candidates[i] = Integer.parseInt(input.readLine());
            sum += candidates[i];
        }

        for(int i = 0; i < candidates.length - 1; i++){
            for(int j = i+1; j < 9; j++){
                if(sum - candidates[i] - candidates[j] == 100){
                    candidates[i] = 0;
                    candidates[j] = 0;
                    Arrays.sort(candidates);
                    for(int k = 2; k < candidates.length; k++){
                        System.out.println(candidates[k]);
                    }
                    return;
                }
            }
        }

    }
}