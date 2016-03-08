package com.jekss.service.registration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jekss on 28.10.15.
 */
public class HashPasswordUser {

    private  String sha1(String text) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(text.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public String salt(String salt, String password) throws NoSuchAlgorithmException {
        return sha1(salt + password);
    }
}
