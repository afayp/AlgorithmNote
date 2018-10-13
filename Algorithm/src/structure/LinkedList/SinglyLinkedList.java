package structure.LinkedList;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        int pos = 0;
        Node p = head;

        while (p != null && pos != index) {
            pos++;
            p = p.next;
        }

        return p;
    }

    public void insertToHead(int value) {
        Node newNode = createNode(value);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            newNode = head;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (p == head) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) return;

        newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) return;
        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }

        if (q == null) return;

        q.next = q.next.next;
    }

    private void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }



    public static Node createNode(int value) {
        return new Node(value,null);
    }

    public static class Node{
        private int data;
        private Node next;


        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }

}
