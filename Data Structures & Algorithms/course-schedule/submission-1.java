class Solution {
    private Map<Integer, List<Integer>> preMap;
    private Set<Integer> visit;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        visit = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] pair : prerequisites){
            int crs = pair[0];
            int pre = pair[1];
            preMap.get(crs).add(pre);
        }

        for(int crs = 0; crs < numCourses; crs++){
            if (!dfs(crs)) return false;
        }
        return true;
    }
    private boolean dfs(int crs){
        if(visit.contains(crs)) return false;
        if(preMap.get(crs).isEmpty()) return true;
        visit.add(crs);
        for(int pre : preMap.get(crs)){
            if(!dfs(pre)) return false;
        }
        visit.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
