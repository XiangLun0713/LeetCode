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
    private HashMap<Integer, Integer> hashMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // stores inorder elements and their corresponding index
        hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }        
        
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int index, int[] inorder, int left, int right) {
        if (index > preorder.length - 1 || left > right) return null;
        
        int currVal = preorder[index];
        TreeNode root = new TreeNode(currVal);
        int inorderIndex = hashMap.get(currVal);
        
        root.left = buildTree(preorder, index + 1, inorder, left, inorderIndex - 1);
        root.right = buildTree(preorder, index + inorderIndex - left + 1, inorder, inorderIndex + 1, right);
        
        return root;
    }
}
