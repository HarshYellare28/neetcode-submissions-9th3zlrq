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
    public int rec(TreeNode curr, int[] diameter){
        if(curr==null) return 0;
        int lh = rec(curr.left, diameter);
        int rh = rec(curr.right, diameter);
        diameter[0] = Math.max(diameter[0], lh+rh);
        return 1 + Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode curr = root;
        int[] diameter = new int[1];
        rec(curr, diameter);
        return diameter[0];
    }
}
