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
        // List to store nodes with coordinates (col, row, val)
        List<int[]> nodes = new ArrayList<>();
        
        // BFS queue: each element is (node, row, col)
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0});
        
        while (!queue.isEmpty()) {
            Object[] arr = queue.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];
            
            if (node != null) {
                nodes.add(new int[]{col, row, node.val});
                queue.offer(new Object[]{node.left, row + 1, col - 1});
                queue.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }
        
        // Sort nodes by column, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // sort by col
            else if (a[1] != b[1]) return a[1] - b[1]; // then row
            else return a[2] - b[2]; // then value
        });
        
        // Group nodes by column
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            int col = node[0], val = node[2];
            if (col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = col;
            }
            result.get(result.size() - 1).add(val);
        }
        
        return result;

    }
}