package com.sun.travel.utils;

import java.security.MessageDigest;

/**
 * @class: MD5Utils <br>
 * @author: sun <br>
 * @date: 2020-03-23 16:51
 */
public class MD5Utils {
    public MD5Utils() {
    }

    public static String md5(String input) {
        StringBuffer sb = new StringBuffer();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] b = md.digest();

            for(int offset = 0; offset < b.length; ++offset) {
                int i = b[offset];
                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    sb.append("0");
                }

                sb.append(Integer.toHexString(i));
            }
        } catch (Exception var6) {
            return null;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
