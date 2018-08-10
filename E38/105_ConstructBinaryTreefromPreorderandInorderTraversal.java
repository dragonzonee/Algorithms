/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return arrangeBT(0,0,inorder.length-1,preorder,inorder);
    }
    
    public TreeNode arrangeBT(int index,int start,int end,int[] preorder,int[] inorder){
        if(index>preorder.length-1|| start > end)
            return null;
        TreeNode root = new TreeNode(preorder[index]);
        int location=0;
        for(int i=start;i<=end;i++){
            if(inorder[i]==preorder[index])
                location = i;
        }
        root.left = arrangeBT(index+1,start,location-1,preorder,inorder);
        root.right = arrangeBT(index+location-start+1,location+1,end,preorder,inorder);
        return root;
    }
}