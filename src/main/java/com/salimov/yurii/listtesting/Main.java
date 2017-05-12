package com.salimov.yurii.listtesting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 */
public class Main {

    private final static int COUNT = 10;

    public static void main(String[] args) {
        System.out.println();
        testList(ArrayList.class);
        testList(LinkedList.class);
        testList(Vector.class);
    }

    private static void testList(Class<? extends List> clazz) {
        double timeTestFilling = 0;
        double timeTestGettingByIndex = 0;
        double timeTestContains = 0;
        double timeTestRemove = 0;
        for (int i = 0; i < COUNT; i++) {
            timeTestFilling += ListTester.testFilling(createList(clazz));
            timeTestGettingByIndex += ListTester.testGettingByIndex(createList(clazz));
            timeTestContains += ListTester.testContains(createList(clazz));
            timeTestRemove += ListTester.testRemove(createList(clazz));
        }
        System.out.println(clazz.getSimpleName() + " result:");
        System.out.println("1) testFilling() = " + (timeTestFilling / COUNT) + " ms");
        System.out.println("2) testGettingByIndex() = " + (timeTestGettingByIndex / COUNT) + " ms");
        System.out.println("3) testContains() = " + (timeTestContains / COUNT) + " ms");
        System.out.println("4) testRemove() = " + (timeTestRemove / COUNT) + " ms");
        System.out.println();
    }

    private static List<Integer> createList(Class clazz) {
        List<Integer> result;
        if (clazz == ArrayList.class) {
            result = new ArrayList<>();
        } else if (clazz == LinkedList.class) {
            result = new LinkedList<>();
        } else {
            result = new Vector<>();
        }
        return result;
    }
}
