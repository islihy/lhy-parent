package org.lhy.sb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

public class MD5Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);


    //公盐
    private static final String PUBLIC_SALT = "demo" ;
    //十六进制下数字到字符的映射数组
    private final static String[] hexDigits = {"0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 用户密码加密，盐值为 ：私盐+公盐
     * @param  password 密码
     * @param  salt 私盐
     * @return  MD5加密字符串
     */
    public static String encryptPassword(String password,String salt){
        return encodeByMD5(PUBLIC_SALT+password+salt);
    }

    /**
     * md5加密算法
     * @param  originString
     * @return
     */
    private static String encodeByMD5(String originString){
        if (originString != null){
            try{
                //创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 转换字节数组为十六进制字符串
     * @param b 字节数组
     * @return  十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b){
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /** 将一个字节转化成十六进制形式的字符串     */
    private static String byteToHexString(byte b){
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

//    public static String md5(String content) {
//        // 用于加密的字符
//        char[] md5String = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
//        try {
//            // 使用平台默认的字符集将md5String编码为byte序列,并将结果存储到一个新的byte数组中
//            byte[] byteInput = content.getBytes();
//
//            // 信息摘要是安全的单向哈希函数,它接收任意大小的数据,并输出固定长度的哈希值
//            MessageDigest mdInst = MessageDigest.getInstance("MD5");
//
//            // MessageDigest对象通过使用update方法处理数据,使用指定的byte数组更新摘要
//            mdInst.update(byteInput);
//
//            //摘要更新后通过调用digest() 执行哈希计算,获得密文
//            byte[] md = mdInst.digest();
//
//            //把密文转换成16进制的字符串形式
//            int j = md.length;
//            char[] str = new char[j*2];
//            int k = 0;
//            for (int i=0;i<j;i++) {
//                byte byte0 = md[i];
//                str[k++] = md5String[byte0 >>> 4 & 0xf];
//                str[k++] = md5String[byte0 & 0xf];
//            }
//            // 返回加密后的字符串
//            return new String(str);
//
//        }catch (Exception e) {
//            LOGGER.warn(e.getMessage(),e);
//            return null;
//        }
//    }
}
