Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


class Solution {
    
    public int threeSumClosest(int[] nums, int target){
        if(nums.length<=2) return 0;
        int res = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int st = i+1, end = nums.length-1;
            while(st<end){
                int sum = nums[st]+nums[end]+nums[i];
                if(sum>target) --end;
                else if(sum<target) ++st;
                else return sum;
                if(Math.abs(sum-target)<Math.abs(res-target)) res = sum;
            }
        }
        return res;
    }
}