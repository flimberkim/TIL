import java.util.*;

/*
아이디어 : 주어진 park의 정보를 바탕으로 공원에 대한 map을 만든다. 그리고 새로운 위치를 구하는 메서드와, 새로운 위치가 유효한지 체크하는 메서드를 생성한다. 새로운 위치가 유효하다면 현재 위치를 갱신하고, 아니면 가만히 둔다.
시간복잡도 : O(N), N 은 park 배열의 길이 * park[0]의 길이
자료구조 : 배열
*/

class Solution {
    
    static int[] point = new int[2];
    static boolean[][] map;
    static int row;
    static int col;
    
    public int[] solution(String[] park, String[] routes) {
        
        row = park.length;
        col = park[0].length();
        
        map = new boolean[row][col];
        
        String temp;
        
        //공원 지도 만들기
        for(int i = 0; i < park.length; i++){
            temp = park[i];
            
            for(int j = 0; j < temp.length(); j++){
                if(temp.charAt(j) == 'S'){
                    point[0] = i;
                    point[1] = j;
                    map[i][j] = true;
                }
                else if(temp.charAt(j) == 'O'){
                    map[i][j] = true;
                }
            }
            
        }
        
        //이동하기
        for(int i = 0; i < routes.length; i++){
            int[] nextPoint = getNextPoint(routes[i]);
            if(check(nextPoint)){
                point = nextPoint;
            }
        }
        
        return point;
        
    }
    
    public int[] getNextPoint(String order){
        
        int[] newPoint = new int[2];
        
        String[] detailOrder = order.split(" ");
        
        if(detailOrder[0].equals("N")){
            newPoint[0] = point[0] - Integer.parseInt(detailOrder[1]);
            newPoint[1] = point[1];
        }
        else if(detailOrder[0].equals("S")){
            newPoint[0] = point[0] + Integer.parseInt(detailOrder[1]);
            newPoint[1] = point[1];
        }
        else if(detailOrder[0].equals("E")){
            newPoint[0] = point[0];
            newPoint[1] = point[1] + Integer.parseInt(detailOrder[1]);
        }
        else{
            newPoint[0] = point[0];
            newPoint[1] = point[1] - Integer.parseInt(detailOrder[1]);
        }
        
        return newPoint;
        
    }
    
    public boolean check(int[] newPoint){
        
        if(point[0] == newPoint[0]){
            
            if(newPoint[1] < 0 || newPoint[1] > col - 1){
                return false;
            }
            
            int start =  Math.min(point[1], newPoint[1]);
            int end = Math.max(point[1], newPoint[1]);
            
            for(int i = start; i < end + 1; i++){
                if(!map[point[0]][i]){
                    return false;
                }
            }
            
            return true;
            
        }
        else {
            if(newPoint[0] < 0 || newPoint[0] > row - 1){
                return false;
            }
            
            int start = Math.min(point[0], newPoint[0]);
            int end = Math.max(point[0], newPoint[0]);
            
            for(int i = start; i < end + 1; i++){
                if(!map[i][newPoint[1]]){
                    return false;
                }
            }
            
            return true;
            
        }
        
    }


}
