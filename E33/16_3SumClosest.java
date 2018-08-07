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