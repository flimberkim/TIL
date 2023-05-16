# LeetCode 문제풀이

## 문제 4번 Median of Two Sorted Arrays(정렬된 두 배열의 전체 값들의 중앙값 구하기)
### 문제<br>
시간복잡도 : O(m+n), m, n은 각각 nums1, nums2의 길이
아이디어 : 각 배열에 대한 포인터를 두고 해당하는 값을 비교해서 작은 값을 mergeArray에 넣고 포인터를 이동한다. 포인터 둘다 각 배열의 인덱스를 넘어가면 그 때 mergeArray의 median값을 찾아 반환한다. <br>

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
<br><br> 

Example 1:<br>
Input: nums1 = [1,3], nums2 = [2]<br>
Output: 2.00000<br>
Explanation: merged array = [1,2,3] and median is 2.<br><br>

Example 2:<br>
Input: nums1 = [1,2], nums2 = [3,4]<br>
Output: 2.50000<br>
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.<br><br>

Constraints:<br>
nums1.length == m<br>
nums2.length == n<br>
0 <= m <= 1000<br>
0 <= n <= 1000<br>
1 <= m + n <= 2000<br>
-10^6 <= nums1[i], nums2[i] <= 10^6<br><br>
## 내 풀이
```
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int num1Length = nums1.length;
            int num2Length = nums2.length;
            int[] mergeArray = new int[num1Length + num2Length];
            int index = 0;
            int num1Index = 0;
            int num2Index = 0;

            //두 배열의 값을 비교하면서 작은 값을 mergeArray에 넣는다.
            while(num1Index < num1Length && num2Index < num2Length){
                if(nums1[num1Index] < nums2[num2Index]){
                    mergeArray[index++] = nums1[num1Index++];
                }else{
                    mergeArray[index++] = nums2[num2Index++];
                }
            }
            
            //아직 끝까지 돌지 못한 배열이 있다면 끝까지 돌면서 값을 mergeArray에 넣어준다.
            while(num1Index < num1Length){
                mergeArray[index++] = nums1[num1Index++];
            }
            
            while(num2Index < num2Length){
                mergeArray[index++] = nums2[num2Index++];
            }
            
            //mergeArray의 중앙값을 구해준다.
            if(mergeArray.length % 2 == 0){
                return (double)(mergeArray[mergeArray.length/2] + mergeArray[mergeArray.length/2 - 1])/2;
            }
            else return mergeArray[mergeArray.length/2];
    }
}
```