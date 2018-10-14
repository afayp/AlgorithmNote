package structure.queue;

public class ArrayQueue {

    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;


    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String value) {
        if (tail == n) return false; // 队满
        items[tail] = value;
        tail++;
        return true;
    }

    public String dequeue() {
        if (tail == head) return null;// 空
        String result = items[head];
        head++;
        return result;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}
