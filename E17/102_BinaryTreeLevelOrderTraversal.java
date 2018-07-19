class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> list = new ArrayList<>();
//         levelOrder(list, root, 0);
//         return list;
//     }
    
//     public void levelOrder(List<List<Integer>> list, TreeNode node, int level) {
//         if (node == null) return;
        
//         if (list.size() == level) 
//             list.add(new ArrayList<>());
        
//         list.get(level).add(node.val);        
//         levelOrder(list, node.left, level + 1);
//         levelOrder(list, node.right, level + 1);
//     }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> ls = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode temNode = queue.poll();
                ls.add(temNode.val);
                if(temNode.left!=null) queue.offer(temNode.left);
                if(temNode.right!=null) queue.offer(temNode.right);
            }
            res.add(ls);
        }
        return res;
    }
}