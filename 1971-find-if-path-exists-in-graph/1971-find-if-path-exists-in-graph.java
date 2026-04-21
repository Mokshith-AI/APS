class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(source);
        visited[source] = true;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            if (node == destination) return true;
            
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }
        
        return false;
        
    }
}