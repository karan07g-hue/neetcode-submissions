class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i + 1; j < n; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int [] {dist, j});
                adj.get(j).add(new int [] {dist, i});
            }
        }

        int res = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[] {0,0});

        while(visit.size() < n){
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int i = curr[1];

            if(visit.contains(i)) continue;
            res += cost;
            visit.add(i);

            for(int[] neighbour : adj.get(i)){
                int neiCost = neighbour[0];
                int nei = neighbour[1];
                if(!visit.contains(nei)){
                    minHeap.offer(new int[] {neiCost, nei});
                }
            }
        }
        return res;
    }
}
