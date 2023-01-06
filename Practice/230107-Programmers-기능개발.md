# Programmers 문제풀이

## 문제 : 코딩테스트연습-스택/큐-기능개발
### 문제<br>
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.<br><br>

제한 사항<br>
- 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
- 작업 진도는 100 미만의 자연수입니다.
- 작업 속도는 100 이하의 자연수입니다.
- 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
<br><br>
입출력 예<br>
progresses	speeds	return<br>
[93, 30, 55]	[1, 30, 5]	[2, 1]<br>
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

## 내 풀이
```
public static int[] solution(int[] progresses, int[] speeds){
        int[] answer = {};
        int[] days = new int[progresses.length];
        int countDay = 0;
        ArrayList<Integer> results = new ArrayList<>();
        int pointer = 0;

        for(int i = 0; i < progresses.length; i++){ //작업이 완료되기까지 걸리는 일수를 계산해서 배열에 넣음
            if ((100 - progresses[i]) % speeds[i] == 0) {
                countDay = (100 - progresses[i]) / speeds[i];
                days[i] = countDay;
            }
            else days[i] = ((100 - progresses[i]) / speeds[i]) + 1;
        }

        for(int i = 0; i < days.length; i++){ //처음값과 그 이후의 값들을 비교하면서 일수가 커지면 해당 인덱스로 포인트를 옮긴다.
            for(int j = i+1; j < days.length; j++){
                if(days[i] < days[j]){
                    pointer = j;
                    results.add(pointer - i); //일수가 증가하기 전까지의 작업의 개수를 구한다.
                    break;
                }
            }
            if(pointer == 0) { //일수가 증가하지 않았다면 전체 개수에서 시작 전 까지의 개수를 뺀다.
                results.add(days.length - i);
                break;
            }
            else{
                i = pointer -1; //다시 비교를 시작할 인덱스를 pointer로 잡기 위해 i값을 pointer-1로 설정
                pointer = 0; //pointer값 초기화
            }
        }
        answer = new int[results.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = results.get(i);
        }

        return answer;
    }
```