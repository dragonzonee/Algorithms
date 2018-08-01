The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.




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
    
//     public int rob(TreeNode root) {
//         if(root==null)
//             return 0;
//         ArrayList<Integer> levelVal = new ArrayList<>();
//         levelVal = getLevelVal(root);
//         int length = levelVal.size()-1;
//         return findMax(levelVal,length);
//     }
    
//     public ArrayList getLevelVal(TreeNode root){
//         LinkedList<TreeNode> quene = new LinkedList<>();
//         ArrayList<Integer> value = new ArrayList<>();
//         quene.offer(root);
//         while(!quene.isEmpty()){
//             int levelVal = 0;
//             for(int i=quene.size();i>0;i--){
//                 TreeNode temNode = quene.poll();
//                 levelVal +=temNode.val;
//                 if(temNode.left!=null)
//                     quene.offer(temNode.left);
//                 if(temNode.right!=null)
//                     quene.offer(temNode.right);
//             }
//             value.add(levelVal);
//         }
//         return value;
//     }
    
//     public int findMax(ArrayList<Integer> ls, int length){
//         // if(length==2)
//         //     return ls.get(2);
//         if(length==1)
//             return Math.max(ls.get(1),ls.get(0));
//         if(length==0)
//             return ls.get(0);
//         return Math.max(ls.get(length)+findMax(ls,length-2),findMax(ls,length-1));
//     }
    
public int rob(TreeNode root) {
    return robSub(root, new HashMap<>());
}

private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
    if (root == null) return 0;
    if (map.containsKey(root)) return map.get(root);
    
    int val = 0;
    
    if (root.left != null) {
        val += robSub(root.left.left, map) + robSub(root.left.right, map);
    }
    
    if (root.right != null) {
        val += robSub(root.right.left, map) + robSub(root.right.right, map);
    }
    
    val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
    map.put(root, val);
    
    return val;
}
}