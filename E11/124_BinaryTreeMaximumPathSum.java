Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42


	
class Solution {
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        findMaxPath(root);
        return max;
    }
    
    public int findMaxPath(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0,findMaxPath(root.left));
        int right = Math.max(0,findMaxPath(root.right));
        max = Math.max(max,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}