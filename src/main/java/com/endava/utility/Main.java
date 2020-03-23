package com.endava.utility;
import java.util.List;
import com.google.common.collect.Lists;
import static com.google.common.collect.Lists.newArrayList;

public class Main {

    public static void main(String[] args) {
        //uses import com.google.common.collect.Lists;
        List<String> list1 = Lists.newArrayList("jedan", "dva", "tri");
        System.out.println(list1);

        //uses import static com.google.common.collect.Lists.newArrayList;
        List<String> list2 = newArrayList("jedan", "dva", "tri");
        System.out.println(list2);
    }
}
