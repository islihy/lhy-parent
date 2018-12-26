package org.lhy.sotami.primary.bean;

import javax.persistence.*;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/12/18 6:14 PM
 */
@Entity
@Table(name = "test")
public class PrimaryTest {
    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
