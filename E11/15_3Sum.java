Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]



class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            while(i!=0 && nums[i]==nums[i-1] &&i<nums.length-2) i++;
            int tgt = -nums[i];
            int st = i+1; int end = nums.length-1;
            while(st<end){
                if(nums[st]+nums[end]==tgt){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[st]);
                    ls.add(nums[end]);
                    res.add(ls);
                    st++;
                    end--;
                    while(st<end&&nums[st]==nums[st-1]){ st++; }
                }else if(nums[st]+nums[end]>tgt){
                    end--;
                }else
                    st++;
            }
        }
        return res;
    }
}