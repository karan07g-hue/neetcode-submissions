class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;

    }
    public void insert(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            remove(oldNode);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if(map.size() > capacity){
            Node lruNode = tail.prev;
            remove(lruNode);

            map.remove(lruNode.key);
        }
    }
}
