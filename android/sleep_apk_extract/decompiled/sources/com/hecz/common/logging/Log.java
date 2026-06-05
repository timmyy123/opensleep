package com.hecz.common.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Log {
    public static Handler handler = null;
    private static boolean isLog = true;
    public static Logger logger = Logger.getLogger("test");

    static {
        try {
            FileHandler fileHandler = new FileHandler("log.txt", false);
            handler = fileHandler;
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        } catch (IOException unused) {
            isLog = false;
        } catch (SecurityException e) {
            e.printStackTrace();
            isLog = false;
        }
    }

    public static void info(String str) {
        logger.log(Level.INFO, str);
    }
}
