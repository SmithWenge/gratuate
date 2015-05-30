package com.team.graduate.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * CopyRight (c) 2015 : 56Team
 * Project : graduate
 * Created by 2015/5/30.
 * Module : md5
 * Comments : md5 convert string
 * JDK Version : 1.7
 *
 * @Author : xfdheyqkf
 * Version : v1.0
 */
public class MD5Util {
    public static String getMD5String(String beMd5ed) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(beMd5ed.getBytes("UTF-8"));
            byte[] photoByte = md.digest();

            //convert the byte to hex format method 1
//				StringBuffer sb = new StringBuffer();
//				for (int i = 0; i < photoByte.length; i++) {
//					sb.append(Integer.toString((photoByte[i] & 0xff) + 0x100, 16).substring(1));
//				}
//
//				System.out.println("Digest(in hex format):: " + sb.toString());

            //convert the byte to hex format method 2
            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<photoByte.length;i++) {
                String hex=Integer.toHexString(0xff & photoByte[i]);
                if(hex.length()==1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
