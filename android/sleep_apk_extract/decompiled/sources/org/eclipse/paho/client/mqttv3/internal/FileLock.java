package org.eclipse.paho.client.mqttv3.internal;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes5.dex */
public class FileLock {
    private RandomAccessFile file;
    private Object fileLock;
    private File lockFile;

    public FileLock(File file, String str) throws Exception {
        this.lockFile = new File(file, str);
        if (ExceptionHelper.isClassAvailable("java.nio.channels.FileLock")) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.lockFile, "rw");
                this.file = randomAccessFile;
                Object objInvoke = randomAccessFile.getClass().getMethod("getChannel", null).invoke(this.file, null);
                this.fileLock = objInvoke.getClass().getMethod("tryLock", null).invoke(objInvoke, null);
            } catch (IllegalAccessException unused) {
                this.fileLock = null;
            } catch (IllegalArgumentException unused2) {
                this.fileLock = null;
            } catch (NoSuchMethodException unused3) {
                this.fileLock = null;
            }
            if (this.fileLock != null) {
                return;
            }
            release();
            throw new Exception("Problem obtaining file lock");
        }
    }

    public void release() {
        try {
            Object obj = this.fileLock;
            if (obj != null) {
                obj.getClass().getMethod("release", null).invoke(this.fileLock, null);
                this.fileLock = null;
            }
        } catch (Exception unused) {
        }
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            this.file = null;
        }
        File file = this.lockFile;
        if (file != null && file.exists()) {
            this.lockFile.delete();
        }
        this.lockFile = null;
    }
}
