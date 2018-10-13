package structure.Array;

public class Array {

    public int[] data;
    private int length;
    private int count;


    public Array(int capacity) {
        data = new int[capacity];
        length = capacity;
        count = 0;
    }


    public int find(int index) {
        if (index < 0 || index >= count) return -1;
        return data[index];
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) return false;
        for (int i = index+1; i < count; i++) {
            data[i-1] = data[i];
        }
        --count;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index >= count) return false;
        if (length == count) return false;


        for (int i = count-1; i <= index; --i) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean insertToTail(int value) {
        if (count == length) return false;
        data[count++] = value;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    public int getSize() {
        return count;
    }

}
