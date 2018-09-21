package spring.context.demo03;

/**
 * 瓦里安·乌瑞恩Varian Wrynn
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/20 下午12:33
 */
public class Varian {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Varian{" +
                "name='" + name + '\'' +
                '}';
    }
}
