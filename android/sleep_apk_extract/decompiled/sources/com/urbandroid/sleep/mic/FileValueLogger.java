package com.urbandroid.sleep.mic;

import com.urbandroid.common.logging.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class FileValueLogger {
    private OutputStream out;

    public FileValueLogger(String str) {
        this.out = null;
        try {
            this.out = new FileOutputStream(new File(str));
        } catch (IOException e) {
            Logger.logSevere(e.getMessage());
        }
    }

    public void close() {
        try {
            this.out.flush();
            this.out.close();
        } catch (IOException e) {
            Logger.logSevere(e.getMessage());
        }
    }

    public void write(byte[] bArr) {
        try {
            this.out.write(bArr);
        } catch (Exception e) {
            Logger.logSevere(e.getMessage());
        }
    }
}
