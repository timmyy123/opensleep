package com.urbandroid.util;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Md5Util {
    public static String md5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Integer.valueOf(b & 255)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public static String md5(String str) {
        try {
            return md5(str.getBytes(OAuth.ENCODING));
        } catch (UnsupportedEncodingException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }
}
