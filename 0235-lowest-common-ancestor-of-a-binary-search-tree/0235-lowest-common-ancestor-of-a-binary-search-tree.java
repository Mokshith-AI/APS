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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         // BST property: left < root < right
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left; // Both nodes are in the left subtree
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right; // Both nodes are in the right subtree
            } else {
                return root; // This is the split point, LCA found
            }
        }
        return null;

    }
}