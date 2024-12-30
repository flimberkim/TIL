import java.util.*;

/*
아이디어 : 주어진 배열을 돌면서 파일의 위치를 찾고, 그때마다 왼쪽 위의 점과 오른쪽 아래 점을 업데이트 해준다. 반복문 돌고 나면 업데이트 해놓은 점만 출력하면 끝!
자료구조 : array
시간복잡도 : O(N), N은 wallpaper 길이 * wallpaper[0]의 길이
*/

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer;
        char[] arr = new char[wallpaper[0].length()];
        
        int minX = 100;
        int minY = 100;
        int maxX = -1;
        int maxY = -1;
        
        for(int i = 0; i < wallpaper.length; i++){
            arr = wallpaper[i].toCharArray();
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        answer = new int[]{minX, minY, ++maxX, ++maxY};
        
        return answer;
    }
}