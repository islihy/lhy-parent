package org.lhy.design.factory.test.stage02;

import java.util.Map;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/3 下午2:54
 */
public interface IMyMessage {
    Map<String, Object> getMessageParam();

    void setMessageParam(Map<String, Object> messageParam);

    void sendMesage() throws Exception;// 发送通知/消息
}
