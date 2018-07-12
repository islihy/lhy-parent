package org.lhy.sb.bean;

import org.lhy.sb.nutz.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/15 下午8:08
 */
@Table("role")
public class Role extends BaseModel implements Serializable {
    @Id
    private int id;
    @Comment("角色名")
    @Column("name")
    private String name;

    @ManyMany(from = "userId",relation = "user_role", to = "roleId")
    private List<User> bloggers;

    @ManyMany(from = "roleId",relation = "role_permission", to = "permissionId")
    private List<Permission> permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getBloggers() {
        return bloggers;
    }

    public void setBloggers(List<User> bloggers) {
        this.bloggers = bloggers;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
