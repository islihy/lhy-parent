package org.lhy.log;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/7/30 下午6:48
 */
public interface Logger {
    void debug(String msg);

    void debug(String format, Object... args);

    void info(String msg);

    void info(String format, Object... args);

    void warn(String msg);

    void warn(String format, Object... args);

    void error(String msg);

    void error(String format, Object... args);

    void fatal(String msg);

    void fatal(String format, Object... args);
}
