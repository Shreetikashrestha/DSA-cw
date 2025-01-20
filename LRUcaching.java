import java.util.HashMap;

public class LRUcaching {
    public static class Node {
        int k;
        int v;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.k = key;
            this.v = value;
            this.prev = this.next = null;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node dummyhead;
    Node dummytail;

    LRUcaching(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyhead = new Node(0, 0);
        dummytail = new Node(0, 0);
        dummyhead.next = dummytail;
        dummytail.prev = dummyhead;
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            node.v = value; // Update the value
            insert(node);
        } else {
            if (map.size() == capacity) {
                // Remove the least recently used node
                removeNode(dummytail.prev);
            }
            Node newnode = new Node(key, value);
            insert(newnode);
        }
    }

    int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            insert(node);
            return node.v;
        }
        return -1;
    }

    void removeNode(Node node) {
        map.remove(node.k);
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        node.prev = node.next = null;
    }

    void insert(Node newnode) {
        map.put(newnode.k, newnode);
        newnode.next = dummyhead.next;
        dummyhead.next.prev = newnode;
        dummyhead.next = newnode;
        newnode.prev = dummyhead;
    }

    public static void main(String[] args) {
        LRUcaching lru = new LRUcaching(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // Should return 1
        lru.put(3, 3); // Evicts key 2
        System.out.println(lru.get(2)); // Should return -1 (not found)
        lru.put(4, 4); // Evicts key 1
        System.out.println(lru.get(1)); // Should return -1 (not found)
        System.out.println(lru.get(3)); // Should return 3
        System.out.println(lru.get(4)); // Should return 4
    }
}
