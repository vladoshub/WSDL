package ru.mmtr.jaxrs.model;

import java.io.Serializable;

public class Human {

    private Long id;

    private String name;

    private Integer age;

    private Integer growth;

    public Human() {
    }

    public Human(String name, Integer age, Integer growth, Long id) {
        this.name = name;
        this.age = age;
        this.growth = growth;
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGrowth() {
        return growth;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Human: " + name + " age:" + age + " growth:" + growth;
    }


}