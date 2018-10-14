package structure.Stack;

public class StackBaseOnLinkedList {

    private Node head;

    public void push(int value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }

    /**
     * 我用-1表示栈中没有数据。
     */
    public int pop() {
        if (head == null) return -1;
        int data = head.data;
        head = head.next;

        return data;
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

    }

}
