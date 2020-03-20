package com.endava.utility.list;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static <E> List<E> createList(E ...  a){

        List<E> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }

        return list;
    }
}
