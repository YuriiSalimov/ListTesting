package com.salimov.yurii.listtesting;

import java.util.List;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 */
public class ListTester {

    private final static int SIZE = 1000000;
    private final static int NANO = 1000000;

    public static double testFilling(List<Integer> list) {
        long startNanoTime = getCurrentNanoTime();
        fillList(list, SIZE);
        long endNanoTime = getCurrentNanoTime();
        return getInterval(startNanoTime, endNanoTime);
    }

    public static double testGettingByIndex(List<Integer> list) {
        fillList(list, SIZE);
        int index = list.size() / 2;
        long startNanoTime = getCurrentNanoTime();
        list.get(index);
        long endNanoTime = getCurrentNanoTime();
        return getInterval(startNanoTime, endNanoTime);
    }

    public static double testContains(List<Integer> list) {
        fillList(list, SIZE);
        int number = list.size() / 2;
        long startTime = getCurrentNanoTime();
        list.contains(number);
        long endTime = getCurrentNanoTime();
        return getInterval(startTime, endTime);
    }

    public static double testRemove(List<Integer> list) {
        fillList(list, SIZE);
        int number = list.size() / 2;
        long startTime = getCurrentNanoTime();
        list.remove(number);
        long endTime = getCurrentNanoTime();
        return getInterval(startTime, endTime);
    }

    private static void fillList(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }

    private static long getCurrentNanoTime() {
        return System.nanoTime();
    }

    private static double getInterval(long startNanoTime, long endNanoTime) {
        return convertToMillis(endNanoTime - startNanoTime);
    }

    private static double convertToMillis(long nanotime) {
        return (double) nanotime / NANO;
    }
}
