Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.



class Solution {
    
    private int val = 0;
    private int level;
   // private boolean visited = false;
    
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return -1;
        probeTree(root, 1);
        return val;
    }
    
    public void probeTree(TreeNode root, int level){
        if(root==null) return;
        if(level>this.level){
            this.level = level;
            val = root.val;
        }
        probeTree(root.left,level+1);
        probeTree(root.right,level+1);
    }
}