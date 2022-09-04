/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, root));
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                if (curr.x < min) min = curr.x;
                if (curr.x > max) max = curr.x;
                
                levelMap.putIfAbsent(curr.x, new ArrayList<>());
                levelMap.get(curr.x).add(curr.node.val);
    
                if (curr.node.left != null) queue.offer(new Pair(curr.x - 1, curr.node.left));
                if (curr.node.right != null) queue.offer(new Pair(curr.x + 1, curr.node.right));
            }
            
            for (Integer key : levelMap.keySet()) {
                List<Integer> list = levelMap.get(key);
                Collections.sort(list);
                hashMap.putIfAbsent(key, new ArrayList<>());
                hashMap.get(key).addAll(list);
            }
        }
        
        for(int i = min; i <= max; i++) {
            result.add(hashMap.get(i));
        }
        
        return result;
    }
}

class Pair {
    int x;
    TreeNode node;
    
    public Pair(int x, TreeNode node) {
        this.x = x;
        this.node = node;
    }
}
