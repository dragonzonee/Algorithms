Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getMax(nums,0,nums.length-1);
    }
    
    public TreeNode getMax(int[] nums, int start, int end){
        if(start>end)//这里的临界条件的判定
            return null;
        int[] max = new int []{nums[start],start};
        for(int i=start;i<=end;i++){//这里使用i<=end来实现对临界条件的判定
            max[0] = Math.max(max[0],nums[i]);
            if(max[0]==nums[i])
                max[1] = i;
        }
        TreeNode root = new TreeNode(max[0]);
        root.left = getMax(nums,start,max[1]-1);
        root.right = getMax(nums,max[1]+1,end);
        return root;
    }
}