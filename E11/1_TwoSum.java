Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 



class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     int[] res = new int[2];
    //     if(nums.length<=1) return res;
    //     int s = 0;
    //     int e = nums.length-1;
    //     while(s<e){
    //         if(nums[s]+nums[e]<target) s++;
    //         if(nums[s]+nums[e]>target) e--;
    //         if(nums[s]+nums[e]==target){
    //             res[0] = s;
    //             res[1] = e;
    //             return res;
    //         }
    //     }
    //     return res;
    // }
    
    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        if(nums.length<2) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}s