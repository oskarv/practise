package com.endava.utility;

import com.endava.utility.list.Lists;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> listOfStrings = Lists.createList("jedan","dva","tri");
        List<Integer> listOfIntegers = Lists.createList(1, 2, 3);
        printList(listOfStrings);
        printList(listOfIntegers);

        List<String> listOfStrings2 = com.google.common.collect.Lists.newArrayList("jedan","dva","tri");
        printList(listOfStrings2);
    }

    private static <E> void printList(List<E> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
