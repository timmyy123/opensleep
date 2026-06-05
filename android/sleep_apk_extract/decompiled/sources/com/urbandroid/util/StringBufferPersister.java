package com.urbandroid.util;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.mic.RawAudioWriter;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes5.dex */
public class StringBufferPersister {
    private static final DateFormat df = new SimpleDateFormat("yy-MM-dd-HH-mm");
    private StringBuilder buffer;
    private final String name;
    private final boolean silent;
    private final int size;
    private final long timestamp;
    private final String timestampStr;
    private boolean writeErrorLogged;

    public StringBufferPersister(String str, int i, boolean z) {
        this.writeErrorLogged = false;
        this.size = i;
        this.name = str;
        this.silent = z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.timestamp = jCurrentTimeMillis;
        this.timestampStr = df.format(Long.valueOf(jCurrentTimeMillis));
        resetBuffer();
    }

    public static StringBufferPersister newNullPersister() {
        return new StringBufferPersister("", 0) { // from class: com.urbandroid.util.StringBufferPersister.1
            @Override // com.urbandroid.util.StringBufferPersister
            public synchronized void flush() {
            }

            @Override // com.urbandroid.util.StringBufferPersister
            public synchronized void update(String str) {
            }
        };
    }

    private void persist() {
        try {
            RawAudioWriter rawAudioWriter = new RawAudioWriter(SharedApplicationContext.getInstance().getContext(), this.name + "_" + this.timestamp + "_" + this.timestampStr + ".txt", this.silent);
            try {
                rawAudioWriter.write(this.buffer.toString());
                rawAudioWriter.close();
            } catch (Throwable th) {
                try {
                    rawAudioWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            if (!this.writeErrorLogged) {
                Logger.logSevere("StringBufferPersister: ", e);
                this.writeErrorLogged = true;
            }
        } finally {
            resetBuffer();
        }
    }

    private void resetBuffer() {
        this.buffer = new StringBuilder();
    }

    public synchronized void flush() {
        if (this.buffer.length() > 0) {
            persist();
        }
    }

    public synchronized void update(String str) {
        this.buffer.append(str);
        if (this.buffer.length() >= this.size) {
            persist();
        }
    }

    public StringBufferPersister(String str, int i) {
        this(str, i, false);
    }
}
