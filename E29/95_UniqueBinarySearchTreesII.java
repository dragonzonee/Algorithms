Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


   class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        return getTree(n,1);
    }
    public List<TreeNode> getTree(int n,int start){
        List<TreeNode> list=new ArrayList<TreeNode>();
        if(n==0){
            list.add(null);
            return list;
        }
      
        if(n==1){
            list.add(new TreeNode(start));
            return list;
        }
        for(int i=1;i<=n;i++){
            List<TreeNode> left=getTree(i-1,start);
            List<TreeNode> right=getTree(n-i,start+i);
            for(TreeNode rl:left){
                for(TreeNode rr:right){
                    TreeNode root=new TreeNode(i+start-1);
                    root.left=rl;
                    root.right=rr;
                    list.add(root);
                }
            }
        }
        return list;
    }
}