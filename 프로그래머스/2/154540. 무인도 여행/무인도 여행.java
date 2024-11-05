import java.util.*;

/*
아이디어 : 바다와 땅을 그리고, bfs 탐색을 하면서 각 섬마다 머물 수 있는 날짜를 answers 배열에 저장한다.
시간복잡도 : O(N), N은 map의 크기(가로*세로)
자료구조 : array
*/

class Solution {
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static List<Integer> answers = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int days = 0;
    
    public int[] solution(String[] maps) {
        int[] answer;
        
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        //지도를 다시 그림. 숫자 0은 바다, 나머지는 무인도이며 값은 머물 수 있는 날짜
        for(int i = 0; i < maps.length; i++){
            String[] temp = maps[i].split("");
            
            for(int j = 0; j < temp.length; j++){
                if(!temp[j].equals("X")){
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
        }
        
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    bfs(new int[] {i, j});
                    
                    if(days == 0){
                        answers.add(-1);
                    }
                    else{
                        answers.add(days);
                    }
                    days = 0;
                }
            }
        }
        
        Collections.sort(answers);
        
        answer = new int[answers.size()];
        
        for(int i = 0; i < answers.size(); i++){
            answer[i] = answers.get(i);
        }
        
        return answer.length == 0 ? new int[] {-1} : answer;
    }
    
    public void bfs(int[] currentPosition){
        int row = currentPosition[0];
        int col = currentPosition[1];
        
        if(!visited[row][col] && map[row][col] != 0){
            days += map[row][col];
            visited[row][col] = true;
            
            for(int i = 0; i < 4; i++){
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];
                
                if(nextRow >= 0 && nextRow < map.length && nextCol >=0 && nextCol < map[0].length && !visited[nextRow][nextCol]){
                    int[] temp = {nextRow, nextCol};
                    bfs(temp);
                }
                
            }
            
        }
    }    
    
}