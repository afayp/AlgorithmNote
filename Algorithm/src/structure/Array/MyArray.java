package structure.Array;

import util.Logger;

/**
 * Array
 */

public class MyArray {

    private int[] intArray;
    private int elems;
    private int length;


    public MyArray(int length) {
        this.length = length;
        intArray = new int[length];
        elems = 0;
    }

    public int getSize() {
        return elems;
    }

    public void display() {
        for (int i = 0; i < elems; i++) {
            Logger.println(intArray[i]+"");
        }
        Logger.println();
    }

    public boolean add(int value) {
        if (elems == length) {
            return false;
        }else {
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    public int get(int index) {
        if (index < 0 || index >= elems) {
            throw new RuntimeException("index invalid");
        }
        return intArray[index];
    }

    public int find(int searchValue) {
        int i;
        for (i = 0; i < elems; i++) {
            if (intArray[i] == searchValue) {
                break;
            }
        }
        if (i == elems) {
            return -1;
        }
        return i;
    }

    public boolean delete(int value) {
        int k = find(value);

        if (k == -1) {
            return false;
        }else {
            if (k == elems-1) {
                elems--;
            }else {
                for (int i = k; i < elems - 1; i++) {
                    intArray[i] = intArray[i+1];
                }
                elems--;
            }
            return true;
        }
    }

    public boolean modify(int oldValue, int newValue) {
        int index = find(oldValue);
        if (index == -1) {
            Logger.println(oldValue+" not exists");
            return false;
        }else {
            intArray[index] = newValue;
            return true;
        }

    }



}
