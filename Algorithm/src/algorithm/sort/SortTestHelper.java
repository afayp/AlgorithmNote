package algorithm.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortTestHelper {

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static Integer[] generateRandomArray(int n , int rangleL, int rangleR) {
        assert rangleL <= rangleR;
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangleR - rangleL + 1) + rangleL));
        }

        return arr;
    }

    // 打印arr数组的所有内容
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i+1]) > 0) return false;
        }
        return true;
    }

    public static void testSort(String sortClassName, Comparable[] arr) {
        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);
            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}


