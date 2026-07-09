class Solution {
    public int[] topKFrequent(int[] nums, int k) {
          Map<Integer, Integer> freq = new HashMap<>();
        for(int num :  nums) freq.put(num, freq.getOrDefault(num , 0) + 1);

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));

        for(int key : freq.keySet()){
            heap.offer(key);
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }
        return result;
    }
}
