package org.lhy.design.factory.test.stage02;

import java.util.Map;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/3 下午2:57
 */
public abstract class MyAbstractMessage implements IMyMessage{
    private Map<String, Object> messageParam;// 这里可以理解为生产产品所需要的原材料库。最好是个自定义的对象，这里为了不引起误解使用Map。

    @Override
    public Map<String, Object> getMessageParam() {
        return messageParam;
    }

    @Override
    public void setMessageParam(Map<String, Object> messageParam) {
        this.messageParam = messageParam;
    }
}
