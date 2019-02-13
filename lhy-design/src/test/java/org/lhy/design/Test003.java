package org.lhy.design;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019/1/24 8:24 PM
 */
public class Test003 {
    private Test003(){
        test();
        test("a","b");
        test(new String[]{"aaa","bbb"});
        test("ccc");
    }

    private void test(){
        System.out.println("test");
    }

    private void test(String...strings){
        for(String str:strings){
            System.out.print(str + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new Test003();
    }
}
