package org.lhy.springboot.demo03;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/10/15 上午10:46
 */
@Component
@ConfigurationProperties("sg")
public class SagerasProperties {
    private List<String> hosts = new ArrayList<>();

    private String[] ports;

    @Override
    public String toString() {
        return "SagerasProperties{" +
                "hosts=" + hosts +
                ", ports=" + Arrays.toString(ports) +
                '}';
    }

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public String[] getPorts() {
        return ports;
    }

    public void setPorts(String[] ports) {
        this.ports = ports;
    }
}
