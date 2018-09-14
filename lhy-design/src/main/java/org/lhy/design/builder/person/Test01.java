package org.lhy.design.builder.person;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/13 下午5:07
 */
public class Test01 {
    public static void main(String[] args) {
        Person1 person1 = new Person1(1,"name",3,"男","185","北京市","123");

        Person2 person2 = new Person2();
        person2.setId(2);
        person2.setName("name");

        Person3 person3 = new Person3.Builder(1,"name")
                .age(2)
                .address("地址")
                .build();
    }
}
