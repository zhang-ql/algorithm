package com.zql.huawei;

import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class AgeNameComparatorExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 30));
        people.add(new Person("David", 25));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // 首先按年龄升序排序
                if (p1.getAge() != p2.getAge()) {
                    return Integer.compare(p1.getAge(), p2.getAge());//基本数据类型，不包含compareTo
                }
                // 年龄相同则按名字字母顺序排序
                return p1.getName().compareTo(p2.getName());
            }
        });

        for (Person person : people) {
            System.out.println(person.getName() + ", " + person.getAge());
        }
    }
}