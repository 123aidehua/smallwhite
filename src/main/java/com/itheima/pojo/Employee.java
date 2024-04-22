package com.itheima.pojo;

public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private String position;

    public void setId(Integer id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }

    public Integer getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public Integer getAge()
    {
        return age;
    }
    public String getPosition()
    {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{"+"id="+id+",name="+name+",age="+age+",position="+position+"}";
    }
}