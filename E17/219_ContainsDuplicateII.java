class Solution {
    //12341
    //O(NK) time complexity and O(1) space
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=1;j<=k&&i+j<nums.length;j++){
    //             if(nums[i]==nums[i+j]) return true;
    //         }
    //     }
    //     return false;
    // }
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k ) return true;
            else map.put(nums[i],i);
        }
        return false;
    }
}