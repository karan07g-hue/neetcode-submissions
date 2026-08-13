class Solution {
    private Map<Integer, List<Integer>> preMap;
    private Set<Integer> visit;
    private Set<Integer> cycle;
    private int[] output;
    private int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] pair : prerequisites){
            int crs = pair[0];
            int pre = pair[1];
            preMap.get(crs).add(pre);
        }
        visit = new HashSet<>();
        cycle = new HashSet<>();
        output = new int[numCourses];
        index = 0;

        for(int crs = 0; crs < numCourses; crs++){
            if(!dfs(crs)) return new int[0];
        }
        return output;
    }
    private boolean dfs(int crs){
        if(cycle.contains(crs)) return false;
        if(visit.contains(crs)) return true;

        cycle.add(crs);
        for(int pre : preMap.get(crs)){
            if(!dfs(pre)) return false;
        }
        cycle.remove(crs);
        visit.add(crs);
        output[index] = crs;
        index++;
        return true;
    }
}
