package org.lhy.design;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-10-10 10:33
 */
public class TestMD5 {

    public static void main(String[] args) {
        System.out.println(md5("abc123"));
    }


    public static String md5(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            re_md5 = buf.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }
}
