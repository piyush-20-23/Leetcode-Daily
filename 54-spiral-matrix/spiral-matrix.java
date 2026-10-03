class Solution {
    int m;
    int n;
    int[][] matrix;
    boolean[][] visited;
    int[][] dir = {
        {0, 1},     // right
        {1, 0},     // down
        {0, -1},    // left
        {-1,0}      // up
    };

    public void solve(int i, int j, int d, List<Integer> list){
        
        visited[i][j] = true;
        list.add(matrix[i][j]);

        int ni = i + dir[d][0];
        int nj = j + dir[d][1];

        // check if current direction is valid
        if(ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]){
            // if true move in current direction 
        }

        else{
            // change direction and try again
            d = (d + 1) % 4;
            ni = i + dir[d][0];
            nj = j + dir[d][1];
            // New direction also has nowhere to go
            if (ni < 0 || ni >= m ||
                nj < 0 || nj >= n ||
                visited[ni][nj]) {
                return;
            }
        }

        solve(ni,nj,d,list);
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.matrix = matrix;

        this.visited = visited = new boolean[m][n];
        List<Integer> list = new ArrayList<>();


        solve(0,0,0, list);

        return list;
    }
}