import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int start = 1;
        ArrayList<Integer> candidates = new ArrayList<>();
        
        //배열 먼저 만들기
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = start++;
            }
        }
        candidates = resetArr(arr, queries);
        
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = candidates.get(i);
        }
        return answer;
    }
    
    public ArrayList<Integer> resetArr(int[][] arr, int[][] queries){
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> nums = new LinkedList<>();
        
        for(int i = 0; i < queries.length; i++){
            int[] temp1 = queries[i];
            int startX = temp1[0]-1;
            int startY = temp1[1]-1;
            int endX = temp1[2]-1;
            int endY = temp1[3]-1;
            int minVal = Integer.MAX_VALUE;
            
            for(int a = startY; a < endY; a++){
                nums.add(arr[startX][a]);
                minVal = Math.min(minVal, arr[startX][a]);
            }
            
            for(int b = startX; b < endX; b++){
                nums.add(arr[b][endY]);
                minVal = Math.min(minVal, arr[b][endY]);
            }
            
            for(int c = endY; c > startY; c--){
                nums.add(arr[endX][c]);
                minVal = Math.min(minVal, arr[endX][c]);
            }
            
            for(int d = endX; d > startX; d--){
                nums.add(arr[d][startY]);
                minVal = Math.min(minVal, arr[d][startY]);
            }
            
            nums.addFirst(nums.pollLast());
            System.out.println("minVal : " + minVal);
            ans.add(minVal);
            
            for(int a = startY; a < endY; a++){
                arr[startX][a] = nums.pollFirst();
            }
            
            for(int b = startX; b < endX; b++){
                arr[b][endY] = nums.pollFirst();
            }
            
            for(int c = endY; c > startY; c--){
                arr[endX][c] = nums.pollFirst();
            }
            
            for(int d = endX; d > startX; d--){
                arr[d][startY] = nums.pollFirst();
            }
        }
        
        return ans;
    }
}