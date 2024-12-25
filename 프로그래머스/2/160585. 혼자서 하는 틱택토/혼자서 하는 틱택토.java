import java.util.*;

/*
아이디어 : 주어진 입력값을 이차원 배열 map에 계산하기 편하게 저장한다. O와 X의 개수, 그리고 각 기호의 완성 여부를 가지고 경우를 나누어서 문제가 있는지 여부를 판단하여 반환한다.
자료구조 : array
시간복잡도 : O(1)
*/

class Solution {
    
    static char[][] map = new char[3][3];
    
    static int oNum = 0;
    static int xNum = 0;
    
    static boolean isOComplete = false;
    static boolean isXComplete = false;
    
    public int solution(String[] board) {
        
        //board를 map으로 다시 그리고 그 과정에서 o와 x의 개수를 센다.
        for(int i = 0; i < 3; i++){
            map[i] = board[i].toCharArray();
            for(int j = 0; j < 3; j++){
                if(map[i][j] == 'O'){
                    oNum++;
                }
                else if(map[i][j] == 'X'){
                    xNum++;
                }
            }
        }
        
        //O의 개수는 X보다 한개만 많을 수 있다.
        if (xNum - oNum > 0 || oNum - xNum > 1) {
            return 0;
        }
        
        isOComplete = isTargetComplete('O', map);
        isXComplete = isTargetComplete('X', map);
        
        //O가 끝났는데 개수 차이가 1개가 아니라면 잘못
        if(isOComplete && xNum + 1 != oNum){
            return 0;
        }
        
        //X가 끝났는데 두 개의 개수가 같지 않다면 잘못
        if(isXComplete && xNum != oNum){
            return 0;
        }
        
        return 1;
    }
    
    public boolean isTargetComplete(char target, char[][] map){
        //가로 체크
        for(int i = 0; i < 3; i++){
            if(map[i][0] == target && map[i][1] == target && map[i][2] == target){
                return true;
            }
        }
        
        //세로 체크
        for(int i = 0; i < 3; i++){
            if(map[0][i] == target && map[1][i] == target && map[2][i] == target){
                return true;
            }
        }
        
        //대각선 체크
        if(map[0][0] == target && map[1][1] == target && map[2][2] == target){
            return true;
        }
        
        if(map[0][2] == target && map[1][1] == target && map[2][0] == target){
            return true;
        }
        
        return false;
    }
}