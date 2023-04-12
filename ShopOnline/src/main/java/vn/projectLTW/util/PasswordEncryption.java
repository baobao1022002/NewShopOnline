package vn.projectLTW.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.MessageDigest;

public class PasswordEncryption {
    public static String toSHA1( String str){
        String salt= "asjrlkmcoewj@tjle;oxqskjhdjksjf1jurVn";
        String result = null;
        str = str + salt;
        try{
            byte[] dataBytes = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.encode(md.digest(dataBytes));

        }catch(Exception e){

        }return result;

    }
}
