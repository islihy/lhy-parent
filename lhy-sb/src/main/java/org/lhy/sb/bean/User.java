package org.lhy.sb.bean;

import org.lhy.sb.nutz.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/11 下午11:58
 */
@Table("user")
public class User extends BaseModel implements Serializable {

    @Id
    private int id;

    @Comment("用户名")
    @Column("user_name")
    private String userName;

    @Comment("密码")
    @Column("password")
    private String password;

    @Column("salt")
    private String salt;

    @ManyMany(from = "user_id",relation = "user_role", to = "role_id")
    private List<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
