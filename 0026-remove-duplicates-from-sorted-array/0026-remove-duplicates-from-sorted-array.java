//시간복잡도 : O(N), N은 배열 nums의 길이
//아이디어 : 배열이 정렬되어 있으므로, 첫번째 값을 기준 값으로 둔다. 차례대로 배열을 탐색하면서 달라지는 값이 나오면 기준 값을 업데이트 해주고, 새로 나온 숫자를 nums[index] 위치에 넣어준다. 그러면 배열을 한 번만 순회하고도 문제가 풀린다.
//자료구조 : 배열

class Solution {
    public int removeDuplicates(int[] nums) {
        int standardNum = nums[0];
        int index = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != standardNum){
                standardNum = nums[i];
                nums[index] = standardNum;
                index++;
            }
        }

        return index;
    }
}