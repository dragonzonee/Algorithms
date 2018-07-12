Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]



class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int st = j+1, end = nums.length-1;
                while(st<end){
                    int sum = nums[st]+nums[end]+nums[i]+nums[j];
                    if(sum==target){
                        res.add(Arrays.asList(nums[st],nums[end],nums[i],nums[j]));
                        while(st<end&&nums[st]==nums[st+1]) st++;
                        while(st<end&&nums[end]==nums[end-1]) end--;
                        st++;
                        end--;
                    }
                    else if(sum>target) end--;
                    else st++;
                }
            }
        }
        return res;
    }
}