Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0


class Solution {
    // public int searchInsert(int[] nums, int target) {
    //     int st = 0, end = nums.length-1;
    //     while(st<=end){
    //         int mid = (st + end)/2;
    //         if(nums[mid]>target){
    //             end = mid-1;
    //         }else if(nums[mid]<target){
    //             st = mid+1;
    //         }else return mid;
    //     }
    //     return st;
    // }
    
    public int searchInsert(int[] nums, int target) {
        for (int i=0; i < nums.length; i++){
            if (target == nums[i] || target < nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}