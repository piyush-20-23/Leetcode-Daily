class Solution {

    int[][] directions = {
			{1,0}, // down
			{-1,0}, // up
			{0,1}, // right
			{0,-1} // left
		};


    public int[][] MultiSourceBFS(List<List<Integer>> grid) {
		int n = grid.size();
		// initialize queue, dist[][] and directions
		Queue<int[]> q = new LinkedList<>();

		int[][] dist = new int[n][n];


		// fill dist with -1
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++) {
				dist[i][j] = -1;
			}
		}

		// fill queue with all the theif positions
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++) {
				if(grid.get(i).get(j) == 1) {
					q.offer(new int[] {i,j});
					dist[i][j] = 0;
				}
			}
		}


		while(!q.isEmpty()) {

			int[] curr = q.poll();
			int i = curr[0];
			int j = curr[1];

			for(int[] dir : directions) {
				int ni = i + dir[0];
				int nj = j + dir[1];


				// bound check
				if(ni < 0 || ni >= n || nj < 0 || nj >= n ) {
					continue;
				}

				// visited check
				if(dist[ni][nj] != -1) {
					continue;
				}

				dist[ni][nj] = dist[i][j] + 1;
				q.offer(new int[] {ni,nj});

			}
		}
        return dist;
	}

    public boolean isSfPossible(int sf, int[][] dist) {
        int n = dist.length;

        // If start or destination itself is unsafe
        if (dist[0][0] < sf || dist[n - 1][n - 1] < sf) {
            return false;
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];

            // Reached destination
            if (i == n - 1 && j == n - 1) {
                return true;
            }

            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                // Bound check
                if (ni < 0 || ni >= n || nj < 0 || nj >= n) {
                    continue;
                }

                // Already visited
                if (visited[ni][nj]) {
                    continue;
                }

                // Cell doesn't satisfy required safeness
                if (dist[ni][nj] < sf) {
                    continue;
                }

                visited[ni][nj] = true;
                q.offer(new int[]{ni, nj});
            }
        }

    return false;
}

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        // List<int[]> posOfOnes = new ArrayList<>();

        // // find pos of ones
        // for(int i = 0; i < n; i ++){
        //     for(int j = 0; j < n; j ++){
        //         if(grid.get(i).get(j) == 1){
        //             posOfOnes.add(new int[]{i,j});
        //         }
        //     }
        // }

        
        
        // find min distance from each point to nearest one
        // for(int i = 0; i < n; i ++){
        //     for(int j = 0; j < n; j ++){

        //         int min = Integer.MAX_VALUE;
                
        //         for(int[] arr : posOfOnes){
        //             int temp = Math.abs(arr[0] - i) + Math.abs(arr[1] - j);
        //             min = (min < temp) ? min : temp;
        //         }

        //         grid.get(i).set(j, min);
        //     }
        // }

        int[][] dist = MultiSourceBFS(grid);

        // binary search to maximize the minimum
        int leftSF = 0;
        int rightSF = 399;
        int maxSF = 0;

        while(leftSF <= rightSF){
            int mid = (leftSF + rightSF) / 2;

            if(isSfPossible(mid, dist)){
                maxSF = (maxSF > mid) ? maxSF : mid;
                leftSF = mid + 1;
            }
            else{
                rightSF = mid - 1;
            }

        }

        
        return maxSF;

    }
}