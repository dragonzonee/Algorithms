
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

class Solution {
    //定义一个queue,从后往前，如果前一位比后一位大，则继续，如果前一位比后一位小
    //则一个一个poll()，因为数据一定是从小往大的，所以poll的时候也一定是从小往大的
    //当找到第一个比nums[i-1]大的数的时候，做替换，然后把后面的数从小到大排列
    //123752 - 125 + min combine
    //i-1>=i continue
    //else swap the least biggest one, since num gets bigger from back to first
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0) return;
        LinkedList<Integer> tail = new LinkedList<>();
        boolean changed = false;
        for(int i=nums.length-1;i>0;i--){
            tail.offer(nums[i]);
            if(nums[i-1]<nums[i]){
                int k=i;
                while(!tail.isEmpty()){
                    int num = tail.poll();
                    if(!changed&&num>nums[i-1]){
                        tail.addFirst(nums[i-1]);
                        nums[i-1] = num;
                        changed = true;
                    }else nums[k++] = num;
                }
                break;
            }
        }
        if(changed) return;
        else{
            tail.offer(nums[0]);
            int i=0;
            while(!tail.isEmpty()){
                nums[i++] = tail.poll();
            }
        }
    }
}