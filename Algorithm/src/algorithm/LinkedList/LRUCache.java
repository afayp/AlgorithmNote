package algorithm.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据（get）和写入数据（set）。
 获取数据get(key)：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
 写入数据set(key, value)：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
 */
public class LRUCache {

    /**
     * 双向链表 + 哈希表
     缓存讲究的就是快，所以我们必须做到O(1)的获取速度，这样看来只有哈希表可以胜任。
     但是哈希表无序的，我们没办法在缓存满时，将最早更新的元素给删去。
     那么是否有一种数据结构，可以将先进的元素先出呢？
     那就是队列。所以我们将元素存在队列中，并用一个哈希表记录下键值和元素的映射，就可以做到O(1)获取速度，和先进先出的效果。
     然而，当我们获取一个元素时，还需要把这个元素再次放到队列头，这个元素可能在队列的任意位置，可是队列并不支持对任意位置的增删操作。
     而最适合对任意位置增删操作的数据结构又是什么呢？是链表。
     我可以用链表来实现一个队列，这样就同时拥有链表和队列的特性了。
     不过，如果仅用单链表的话，在任意位置删除一个节点还是很麻烦的，要么记录下该节点的上一个节点，要么遍历一遍。
     所以双向链表是最好的选择。我们用双向链表实现一个队列用来记录每个元素的顺序，用一个哈希表来记录键和值的关系，就行了。
     */

    private class Node {
        Node prev, next;
        int val, key;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
            prev = null;
            next = null;
        }
    }

    private int capacity;
    private HashMap<Integer,Node> hashMap = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);


    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            moveToTail(node);
            return node.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node node = hashMap.get(key);
        if (node != null) {
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToTail(node);
        }else {
            node = new Node(key,value);
            hashMap.put(key,node);
            moveToTail(node);
        }
        if (hashMap.size() > capacity) {
            hashMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

    }

    private void moveToTail(Node n) {
        n.next = tail;
        n.prev = tail.prev;
        tail.prev.next = n;
        tail.prev = n;
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1,1);
        lruCache.set(2,2);
        lruCache.set(3,3);
        lruCache.set(3,5);

        lruCache.get(2);


        Node cur = lruCache.head;
        while (cur.next != null) {
            System.out.println(cur.next.val);
            cur = cur.next;
        }
    }
}
