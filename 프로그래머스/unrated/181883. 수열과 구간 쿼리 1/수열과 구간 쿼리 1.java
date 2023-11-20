class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int i = 0; i < queries.length; i++){
            int[] tempArr = queries[i];
            
            for(int j = tempArr[0]; j <= tempArr[1]; j++){
                arr[j]++;
            }
        }
        
        return arr;
    }
}