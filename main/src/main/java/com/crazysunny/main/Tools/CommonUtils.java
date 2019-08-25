package com.crazysunny.main.Tools;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class CommonUtils {

    public static String PASSWORDHEX = "salt";

    public static String GetMD5Pwd(String userName,String password)
    {
        String md5 = new SimpleHash("MD5",password, ByteSource.Util.bytes(userName + PASSWORDHEX),2).toHex();
        return md5;
    }
}
