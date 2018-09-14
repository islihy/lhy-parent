package org.lhy.log;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/7/30 下午7:stage01
 */
public class Test {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getInstance().getConLogger(Test.class);
        logger.warn("winter is coming");
        logger.debug("%s said, 'valar morghulis'", "Jaqen H'ghar");
        logger.info("%s answered: %s", "Arya", "Valar Dohaeris");
    }
}
