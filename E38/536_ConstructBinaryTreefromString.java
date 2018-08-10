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
    public TreeNode str2tree(String s) {
        if(s.length()==0) return null;
        TreeNode root = new TreeNode(getNum(s,0));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='('){
                int num = getNum(s,i+1);
                TreeNode newNode = new TreeNode(num);
                if(stack.peek().left==null) stack.peek().left = newNode;
                else stack.peek().right = newNode;
                stack.push(newNode);
            }
            if(s.charAt(i)==')') stack.pop();
        }
        return root;
    }
    
    public int getNum(String s, int st){
        int res = 0;
        int sign = 1;
        while(st<s.length()&&s.charAt(st)!='(' && s.charAt(st)!=')'){
            if(s.charAt(st)=='-') sign *= -1;
            else res = res*10 + s.charAt(st)-'0';
            st++;
        }
        return res*sign;
    }
}