package com.philips.lighting.hue.sdk.utilities.impl;

/* JADX INFO: loaded from: classes4.dex */
public class PHLog {
    public static final int DEBUG = 4;
    public static final int ERROR = 2;
    public static final int SUPPRESS = 1;
    public static final int WARN = 3;
    private static boolean debug = false;
    private static boolean error = false;
    private static boolean info = false;
    private static int sdkLogLevel = 1;
    private static boolean warn;

    public static void d(String str, String str2) {
        if (debug) {
            System.out.println(String.valueOf(str) + " " + str2);
        }
    }

    public static void e(String str, String str2) {
        if (error) {
            System.out.println(String.valueOf(str) + " " + str2);
        }
    }

    public static int getSdkLogLevel() {
        return sdkLogLevel;
    }

    public static void i(String str, String str2) {
        if (info) {
            System.out.println(String.valueOf(str) + " " + str2);
        }
    }

    public static boolean isLoggable() {
        return sdkLogLevel > 1;
    }

    public static void setSdkLogLevel(int i) {
        info = false;
        debug = false;
        warn = false;
        error = false;
        sdkLogLevel = i;
        if (i == 2) {
            error = true;
        } else {
            if (i != 3) {
                if (i == 4) {
                    debug = true;
                }
            }
            warn = true;
            error = true;
        }
        info = true;
    }

    public static void w(String str, String str2) {
        if (warn) {
            System.out.println(String.valueOf(str) + " " + str2);
        }
    }
}
