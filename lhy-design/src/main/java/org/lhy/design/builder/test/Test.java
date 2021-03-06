package org.lhy.design.builder.test;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/7/31 下午3:55
 */
public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Director director = new Director();
        ComputerBuilder hp = new HPComputerBuilder();
        ComputerBuilder dell = new DELLComputerBuilder();
        director.setComputerBuilder(hp);
        director.setComputerBuilder(dell);
        director.constructComputer();
        Computer pc = director.getComputer();
    }
}
