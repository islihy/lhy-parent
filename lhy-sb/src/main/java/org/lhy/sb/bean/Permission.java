package org.lhy.sb.bean;

import org.lhy.sb.nutz.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/15 下午8:06
 */
@Table("permission")
public class Permission extends BaseModel implements Serializable {
    @Id
    private int pid;
    @Comment("权限名称")
    @Column("name")
    private String name;
    @Comment("资源")
    @Column("url")
    private String url;

    @ManyMany(from = "permission_id",relation = "role_permission", to = "role_id")
    private List<Role> roles;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
