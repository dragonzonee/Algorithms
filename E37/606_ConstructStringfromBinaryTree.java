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
    //这一题比较考研解题思维
    public String tree2str(TreeNode t) {
        if(t==null) return "";
        String ans = t.val+"";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if(left==""&&right=="") return ans;
        if(left=="") return ans+"()("+right+")";
        if(right=="") return ans+"("+left+")";
        return ans+"("+left+")("+right+")";
    }
}