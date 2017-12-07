package com.salimov.yurii.listtesting;

import java.util.List;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 */
public final class ListTester {

    private final static int NANO = 1000000;

    private final int size;

    public ListTester(final int size) {
        this.size = size;
    }

    public double testFilling(final List<Integer> list) {
        final long startNanoTime = getCurrentNanoTime();
        fillList(list);
        final long endNanoTime = getCurrentNanoTime();
        return getInterval(startNanoTime, endNanoTime);
    }

    public double testGettingByIndex(final List<Integer> list) {
        fillList(list);
        final int index = list.size() / 2;
        final long startNanoTime = getCurrentNanoTime();
        list.get(index);
        final long endNanoTime = getCurrentNanoTime();
        return getInterval(startNanoTime, endNanoTime);
    }

    public double testContains(final List<Integer> list) {
        fillList(list);
        final int number = list.size() / 2;
        final long startTime = getCurrentNanoTime();
        list.contains(number);
        final long endTime = getCurrentNanoTime();
        return getInterval(startTime, endTime);
    }

    public double testRemove(final List<Integer> list) {
        fillList(list);
        final int number = list.size() / 2;
        final long startTime = getCurrentNanoTime();
        list.remove(number);
        final long endTime = getCurrentNanoTime();
        return getInterval(startTime, endTime);
    }

    private void fillList(final List<Integer> list) {
        for (int i = 0; i < this.size; i++) {
            list.add(i);
        }
    }

    private long getCurrentNanoTime() {
        return System.nanoTime();
    }

    private double getInterval(final long startNanoTime, final long endNanoTime) {
        return convertToMillis(endNanoTime - startNanoTime);
    }

    private double convertToMillis(final long nanotime) {
        return (double) nanotime / NANO;
    }
}
