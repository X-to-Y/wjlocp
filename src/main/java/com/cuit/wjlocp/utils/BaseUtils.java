package com.cuit.wjlocp.utils;

import org.apache.tomcat.util.buf.HexUtils;

import java.util.Base64;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}13:23
 */
public class BaseUtils {
    /**
     * base63加密
     * @param content
     * @return
     */
    public static byte[] base64Encrypt(final String content) {
        return Base64.getEncoder().encode(content.getBytes());
    }

    /**
     * base64解密
     * @param encoderContent 已加密内容
     * @return byte[]
     */
    public static byte[] base64Decrypt(final byte[] encoderContent) {
        return Base64.getDecoder().decode(encoderContent);
    }

    /**
     * 加密实现访法
     * @param s
     * @return
     */
    public static String baseEncode(String s){
        byte[] base64Encrypt =  com.cuit.wjlocp.utils.BaseUtils.base64Encrypt(s);
        String toHexString = HexUtils.toHexString(base64Encrypt);
        return toHexString;
    }

    public static String convertBase(String s){
        byte[] base64Encrypt = HexUtils.fromHexString(s);
//        byte[] base64Encrypt = BaseUtils.base64Encrypt("123456789");
        String toHexString = HexUtils.toHexString(base64Encrypt);//将得到得字节转换为字符串
        byte[] base64Decrypt = com.cuit.wjlocp.utils.BaseUtils.base64Decrypt(base64Encrypt);
        String reslut = new String(base64Decrypt);
        return reslut;
    }
}
