package org.lhy.design.factory.test.stage01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午8:12
 */
public class SimpleNoodlesFactory {

    public static final int TYPE_LZ = 1;
    public static final int TYPE_SX = 2;

    public static Noodles createNoodles(int type) {
        switch (type) {
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_SX:
                return new SxNoodles();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        SimpleNoodlesFactory.createNoodles(2).desc();
    }
}
