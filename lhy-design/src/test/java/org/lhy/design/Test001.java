package org.lhy.design;

import java.util.*;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019/1/25 12:51 AM
 */

interface NameValuePair {
    String getName();

    String getValue();
}

public class Test001 {


    public Test001(){

        Map<String, Object> parameterMap = new HashMap<>();

        parameterMap.put("filePath", Arrays.asList("l1","l2"));
        parameterMap.put("filePaths", new String[]{"1122","2233"});

        List list = test(parameterMap);
        System.out.println(list);
    }

    public List test(Map<String, Object> reqMap){
        List<NameValuePair> params = new ArrayList<>();
        if (reqMap != null && reqMap.keySet().size() > 0) {
            Iterator<Map.Entry<String, Object>> iter = reqMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Object> entity = iter.next();
                params.add(new BasicNameValuePair(entity.getKey(), String.valueOf(entity.getValue())));
            }
        }
        return params;
    }

    public static void main(String[] args) {
//        new Test001();



//        String str0 = String.valueOf(Arrays.asList("l1","l2").toString());
        String str0 = String.valueOf(Arrays.toString(new String[]{"1122","2233"}));
        String str1 = String.valueOf(new String[]{"1122","2233"}.toString());
        System.out.println(str0);
        System.out.println(str1);

    }

}
