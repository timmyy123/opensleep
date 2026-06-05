package com.urbandroid.sleep.mic;

import com.urbandroid.common.logging.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class FileLogger {
    private BufferedWriter writer;

    public FileLogger(String str) {
        this.writer = null;
        try {
            this.writer = new BufferedWriter(new FileWriter(new File(str)));
        } catch (IOException e) {
            Logger.logSevere(e.getMessage());
        }
    }

    public void close() {
        try {
            this.writer.flush();
            this.writer.close();
        } catch (IOException e) {
            Logger.logSevere(e.getMessage());
        }
    }

    public void write(String str) {
        try {
            this.writer.write(str);
            this.writer.newLine();
        } catch (Exception e) {
            Logger.logSevere(e.getMessage());
        }
    }
}
