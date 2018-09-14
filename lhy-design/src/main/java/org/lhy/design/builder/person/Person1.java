package org.lhy.design.builder.person;

/**
 * 重叠构造函数模式
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/13 下午5:01
 */
public class Person1 {
    /**
     * 必填参数
     */
    private final int id;
    private final String name;
    /**
     * 可选参数
     */
    private final int age;
    private final String sex;
    private final String phone;
    private final String address;
    private final String desc;

    public Person1(int id, String name) {
        this(id, name, 0);
    }

    public Person1(int id, String name, int age) {
        this(id, name, age, "");
    }

    public Person1(int id, String name, int age, String sex) {
        this(id, name, age, sex, "");
    }

    public Person1(int id, String name, int age, String sex, String phone) {
        this(id, name, age, sex, phone, "");
    }

    public Person1(int id, String name, int age, String sex, String phone, String address) {
        this(id, name, age, sex, phone, address, "");
    }

    public Person1(int id, String name, int age, String sex, String phone, String address, String desc) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
        this.desc = desc;
    }

}
