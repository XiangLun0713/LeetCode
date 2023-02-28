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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        helper(root, hashMap, result);
        return result;
    }

    private String helper(TreeNode root, HashMap<String, Integer> hashMap, List<TreeNode> result) {
        if (root == null) return "#";
        String left = helper(root.left, hashMap, result);
        String right = helper(root.right, hashMap, result);
        String temp = root.val + "," + left + "," + right;
        hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
        if (hashMap.get(temp) == 2) result.add(root);
        return temp;
    }
}
