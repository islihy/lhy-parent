package org.lhy.log;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/7/30 下午6:50
 */
public interface LoggerBuilder {
    /**
     * 运行时日志
     *
     * @param T
     * @return
     */
    Logger getRunLogger(Class<?> T);

    /**
     * 命令行日志
     *
     * @param T
     * @return
     */
    Logger getConLogger(Class<?> T);
}
