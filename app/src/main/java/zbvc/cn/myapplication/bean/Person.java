package zbvc.cn.myapplication.bean;

/**
 * Created by Lenovo on 2017/12/4.
 */

public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String phone;
    public Person(){}

    public Person(Integer id, String name, Integer age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Person(String name, Integer age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
