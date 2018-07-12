Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].



class Solution {
    //brute search
    // public int subarraySum(int[] nums, int k) {
    //     int res = 0;
    //     for(int i=0;i<nums.length;i++){
    //         int sum = 0;
    //         for(int j=i;j<nums.length;j++){
    //             sum += nums[j];
    //             if(sum==k) res++;
    //         }
    //     }
    //     return res;
    // }
    
    public int subarraySum(int[] nums, int k){
        //sum[i,j] = sum[0,j] - sum[0,i-1]
        //if sum[i,j]==k
        //it means sum[0,j] - sum[0,i-1] = k, and j>i
        //if sum[j]-k = sum[i], we get an anwser
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);//here is the tricky part
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)) res += map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}