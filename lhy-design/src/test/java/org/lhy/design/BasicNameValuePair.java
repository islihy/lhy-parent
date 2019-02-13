package org.lhy.design;

import java.io.Serializable;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019/1/25 12:54 AM
 */
public class BasicNameValuePair implements NameValuePair, Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String name, String value) {
        this.name = (String)this.notNull(name, "Name");
        this.value = value;
    }

    public static <T> T notNull(T argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " may not be null");
        } else {
            return argument;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        if (this.value == null) {
            return this.name;
        } else {
            int len = this.name.length() + 1 + this.value.length();
            StringBuilder buffer = new StringBuilder(len);
            buffer.append(this.name);
            buffer.append("=");
            buffer.append(this.value);
            return buffer.toString();
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof NameValuePair)) {
            return false;
        } else {
            BasicNameValuePair that = (BasicNameValuePair)object;
            return this.name.equals(that.name) && LangUtils.equals(this.value, that.value);
        }
    }

    public int hashCode() {
        int hash = 17;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        return hash;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
