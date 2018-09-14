package org.lhy.design.builder.person;

/**
 * JavaBeans模式
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/13 下午5:04
 */
public class Person2 {

    /**必要参数
     *
     */
    private int id;
    private String name;
    /**可选参数
     *
     */
    private int age;
    private String sex;
    private String phone;
    private String address;
    private String desc;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
