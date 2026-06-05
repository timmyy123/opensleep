package com.hecz.common.tools;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public class Log {
    public static Log logger = new Log();

    public void log(Level level, String str) {
        android.util.Log.i("J2XX-LOG", "text:" + str);
    }
}
