package org.lhy.sb.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/7/24 下午3:50
 */
public class StringUtil extends StringUtils{


    @SuppressWarnings("unchecked")
    public static Set<String> splitC(String str) {

        Set<String> set = new HashSet<>();
        if (StringUtils.isEmpty(str)) {
            return set;
        }
        set.addAll(CollectionUtils.arrayToList(str.split(",")));
        return set;
    }
}
