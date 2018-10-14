package structure.queue;

public class DynamicArrayQueue {

    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        //tail == n表示队列末尾没有空间了
        if (tail == n) {
            // tail ==n && head==0，表示整个队列都占满了
            if (head == 0) return false;

            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }

            tail = tail - head;
            head = 0;
        }

        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String value = items[head];
        head++;
        return value;
    }

    private void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }



}
