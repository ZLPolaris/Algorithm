package com.learn.MST17_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Person {
    public int height;
    public int weight;

    public Person() {
    }

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}

public class SolutionOne {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            people.add(new Person(height[i], weight[i]));
        }
        people.sort(((o1, o2) -> {
            int k1 = Integer.compare(o1.height, o2.height);
            if (k1 != 0) {
                return k1;
            } else {
                return Integer.compare(o1.weight, o2.weight);
            }
        }));
        System.out.println(people);
        int res = 0;
        Person select = null;
        Person front = null;
        for (int i = 0; i < n; i++) {
            if (i == 0 || people.get(i).weight > people.get(i - 1).weight) {
                res++;
                front = people.get(i);
            }
        }
        return res;
    }
}
