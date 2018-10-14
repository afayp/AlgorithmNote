package structure.queue;

/**
 * 基于链表实现的队列
 */
public class LinkedListQueue {


    private Node head = null;
    private Node tail = null;


    public void enqueue(String value) {
        if (tail == null) { // 空
            Node node = new Node(value, null);
            head = node;
            tail = node;
        }else {
            tail.next = new Node(value,null);
            tail = tail.next;
        }
    }

    public String dequeue() {
        if (head == null) return null;
        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = this.head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }



    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

}
