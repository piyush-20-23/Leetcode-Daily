class Solution {
    boolean[] visited;
    List<Integer>[] adg;

    int V, E;

    public void dfs(int node){

        // mark as visited
        visited[node] = true;

        // increament vertices and edges
        V ++;
        E += adg[node].size();

        // iterate through every neighbour 
        for(int neighbour : adg[node]){
            if(!visited[neighbour])
                dfs(neighbour);
        }
    }


    public int countCompleteComponents(int n, int[][] edges) {
        adg = new List[n];

        // this will give each row the same object reference
        // Arrays.fill(adg, new ArrayList<>());

        for(int i = 0; i < n; i ++){
            adg[i] = new ArrayList<>();
        }

        // add edge to the adjacency array
        for(int i = 0; i < edges.length; i ++){
            int u = edges[i][0];
            int v = edges[i][1];

            adg[u].add(v);
            adg[v].add(u);
        }

        visited = new boolean[n];
        int componentCount = 0;

        for(int i = 0; i < n; i ++){
            V = 0;
            E = 0;
            if(!visited[i])
                dfs(i);

            if(E == (V * (V - 1)) && V != 0)
                componentCount ++;
        }

        return componentCount;
    }
}