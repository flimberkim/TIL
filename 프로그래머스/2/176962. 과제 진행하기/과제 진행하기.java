import java.util.*;

/*
아이디어 : plans 배열을 돌면서 각 과제를 수행한다. 남는 시간이 있으면 저장하고, 다음 과제와의 계산을 통해서 waitingList를 따로 관리한다.
시간복잡도 : O(N), N은 plans 의 길이 
자료구조 : array, map
*/

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<String> tempAnswer = new ArrayList<>();
        
        //첫번째 인덱스부터 시, 분, 남은시간을 저장
        int[] timeRecord = new int[3];
        int index = 0;
        String name;
        String[] time;
        Integer processTime;
        String[] nextTime;
        int difference;
        
        Arrays.sort(plans, (a,b) -> compareTimes(a[1],b[1]));
        
        Stack<String> waitingList = new Stack<>();
        Map<String, Integer> leftTimeRecord = new HashMap<>();
        
        while(index < plans.length){
            name = plans[index][0];
            time = plans[index][1].split(":");
            processTime = Integer.parseInt(plans[index][2]);            
            
            if(index + 1 < plans.length){
                nextTime = plans[index+1][1].split(":");
            }
            else{
                tempAnswer.add(name);
                while(!waitingList.isEmpty()){
                    tempAnswer.add(waitingList.pop());
                }
                break;
            }
            
            //다음 시작까지 시간차이(단위 : 분)
            difference = getDifference(time, nextTime);
            
            if(processTime > difference){
                leftTimeRecord.put(name, processTime - difference);
                waitingList.add(name);
                index++;
                continue;
            }
            else if(processTime == difference){
                tempAnswer.add(name);
                index++;
                continue;
            }
            else{
                int surplus = difference - processTime;
                
                tempAnswer.add(name);
                
                while(surplus > 0 && !waitingList.isEmpty()){
                    
                    int newLeftTime = leftTimeRecord.get(waitingList.peek());
                    
                    if(surplus == newLeftTime){
                        tempAnswer.add(waitingList.pop());
                        break;
                    }
                    else if(surplus < newLeftTime){
                        leftTimeRecord.put(waitingList.peek(), newLeftTime-surplus);
                        break;
                    }
                    else{
                        surplus -= newLeftTime;
                        tempAnswer.add(waitingList.pop());
                    }
                    
                }
                
                index++;
            }
            
        }
               
        
        
        return tempAnswer.stream().toArray(String[]::new);
    }
    
    public int compareTimes(String time1, String time2){
        String[] temp1 = time1.split(":");
        String[] temp2 = time2.split(":");
        
        int temp1Hour = Integer.parseInt(temp1[0]);
        int temp1Min = Integer.parseInt(temp1[1]);
        int temp2Hour = Integer.parseInt(temp2[0]);
        int temp2Min = Integer.parseInt(temp2[1]);
        
        if(temp1Hour != temp2Hour){
            return temp1Hour - temp2Hour;
        }
        else {
            return temp1Min - temp2Min;
        }
        
    }
    
    public int getDifference(String[] time1, String[] time2){
        return (Integer.parseInt(time2[0])*60 + Integer.parseInt(time2[1])) - (Integer.parseInt(time1[0])*60 + Integer.parseInt(time1[1]));
    }
}