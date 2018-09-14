package org.lhy.design.factory.test.stage02;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/3 下午2:54
 */
public interface IMyMessageFactory {

    IMyMessage createMessage(String messageType);
}
