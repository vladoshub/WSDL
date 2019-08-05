package ru.mmtr.jaxrs.searchcriteria;

import javax.ws.rs.QueryParam;

public class SearchCriteria {
    @QueryParam("name")
    private String name;
    @QueryParam("age")
    private Integer age;
    @QueryParam("growth")
    private Integer growth;

    public void setName(String name) {
        this.name = name;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGrowth() {
        return growth;
    }

    public SearchCriteria(){

    }

    public SearchCriteria(String name,int age,int growth){
        this.name=name;
        this.age=age;
        this.growth=growth;

    }
      public boolean isNull(){
            return name==null&&age==null&&growth==null;
      }
}
