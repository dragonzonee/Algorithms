class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //112333788
        //123456789
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int i = 0, j=0;
        while(i<=nums.length){
            if(nums[j]==i+1){
                i++;
                j++;
            }
            else if(nums[j]<i+1){
                j++;
            }
            else if(nums[j]>i+1){
                res.add(i+1);
                i++;
            }
            if(j==nums.length-1&&nums[j]<nums.length){
                while(i<=nums.length){
                    res.add(i++);
                }
            }
        }
        return res;
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}