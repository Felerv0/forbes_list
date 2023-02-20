package com.example.forbesandroid.model;

public class Person {
    private String name;
    private int flag;
    private String netWorth;

    public Person(String name, int flag, String netWorth) {
        this.name = name;
        this.flag = flag;
        this.netWorth = netWorth;
    }

    public String getName() {
        return name;
    }

    public int getFlag() {
        return flag;
    }

    public String getNetWorth() {
        return netWorth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", flag=" + flag +
                ", netWorth='" + netWorth + '\'' +
                '}';
    }
}
