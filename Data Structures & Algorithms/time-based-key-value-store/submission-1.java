class TimeMap {
    class Pair{
        int timestamp;
        String value;
        
        public Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;

        }
    }
        HashMap<String, List<Pair>> map;
    

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair> list = map.get(key);
        int lo = 0;
        int hi = list.size() - 1;
        String result = "";

        while(lo <= hi){
            int mid = lo + (hi - lo)/ 2;
            if(list.get(mid).timestamp <= timestamp){
                result = list.get(mid).value;
                lo = mid+ 1;
            } else{
                hi = mid - 1;
            }
        }
        return result;
    }
}
