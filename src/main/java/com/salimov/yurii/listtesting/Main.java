package com.salimov.yurii.listtesting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public class Main {

    private final static int COUNT = 10;

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testVector();
    }

    private static void testArrayList() {
        double timeTestFilling = 0;
        double timeTestGettingByIndex = 0;
        double timeTestContains = 0;
        for (int i = 0; i < COUNT; i++) {
            timeTestFilling += ListTester.testFilling(new ArrayList<>());
            timeTestGettingByIndex += ListTester.testGettingByIndex(new ArrayList<>());
            timeTestContains += ListTester.testContains(new ArrayList<>());
        }
        System.out.println("ArrayList result:");
        System.out.println("1) testFilling() = " + (timeTestFilling / COUNT) + " ms");
        System.out.println("2) testGettingByIndex() = " + (timeTestGettingByIndex / COUNT) + " ms");
        System.out.println("3) testContains() = " + (timeTestContains / COUNT) + " ms");
        System.out.println();
    }

    private static void testLinkedList() {
        double timeTestFilling = 0;
        double timeTestGettingByIndex = 0;
        double timeTestContains = 0;
        for (int i = 0; i < COUNT; i++) {
            timeTestFilling += ListTester.testFilling(new LinkedList<>());
            timeTestGettingByIndex += ListTester.testGettingByIndex(new LinkedList<>());
            timeTestContains += ListTester.testContains(new LinkedList<>());
        }
        System.out.println("LinkedList result:");
        System.out.println("1) testFilling() = " + (timeTestFilling / COUNT) + " ms");
        System.out.println("2) testGettingByIndex() = " + (timeTestGettingByIndex / COUNT) + " ms");
        System.out.println("3) testContains() = " + (timeTestContains / COUNT) + " ms");
        System.out.println();
    }

    private static void testVector() {
        double timeTestFilling = 0;
        double timeTestGettingByIndex = 0;
        double timeTestContains = 0;
        for (int i = 0; i < COUNT; i++) {
            timeTestFilling += ListTester.testFilling(new Vector<>());
            timeTestGettingByIndex += ListTester.testGettingByIndex(new Vector<>());
            timeTestContains += ListTester.testContains(new Vector<>());
        }
        System.out.println("Vector result:");
        System.out.println("1) testFilling() = " + (timeTestFilling / COUNT) + " ms");
        System.out.println("2) testGettingByIndex() = " + (timeTestGettingByIndex / COUNT) + " ms");
        System.out.println("3) testContains() = " + (timeTestContains / COUNT) + " ms");
        System.out.println();
    }
}
