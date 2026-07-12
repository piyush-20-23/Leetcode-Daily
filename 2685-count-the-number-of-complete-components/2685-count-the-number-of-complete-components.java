class Solution {

    boolean[] visited;
    List<List<Integer>> adj;
    int componentCount; 
    int n;
    int edg;
    int ver;

    public int countCompleteComponents(int n, int[][] edges) {
        this.n = n;
        // create adjacency List
        adj = new ArrayList<>();

        for(int i = 0; i < n; i ++){
            adj.add( new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i ++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // iterate through every node if it not visited by dfs
        componentCount = 0;
        visited = new boolean[n];

        ver = 0;
        edg = 0;
        
        for(int i = 0; i < n; i ++){
            ver = 0;
            edg = 0;
            if(!visited[i]){
                dfs(i);
            }

            if((ver * (ver -1)) / 2 == edg/2 && ver != 0){
                componentCount ++;
            }
        }


        return componentCount;
    }

    public void dfs(int node){
        
        visited[node] = true;
        ver ++;
        edg += adj.get(node).size();
        
        
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour);
            }
        }
    }
}