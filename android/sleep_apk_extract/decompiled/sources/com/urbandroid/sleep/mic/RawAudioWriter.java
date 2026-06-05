package com.urbandroid.sleep.mic;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.util.ScienceUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class RawAudioWriter implements Closeable {
    private final Context context;
    private FileChannel out;

    public RawAudioWriter(Context context, String str, boolean z) {
        this.context = context;
        this.out = null;
        try {
            new File(context.getExternalFilesDir(null).getAbsolutePath() + "/sleep-data/").mkdirs();
            File file = new File(context.getExternalFilesDir(null).getAbsolutePath() + "/sleep-data/" + str);
            this.out = new FileOutputStream(file, file.length() > 0).getChannel();
            if (!z) {
                Logger.logInfo("Raw data: " + file.getAbsolutePath() + " size " + this.out.size());
            }
            if (this.out.size() > 0) {
                FileChannel fileChannel = this.out;
                fileChannel.position(fileChannel.size());
            }
        } catch (Exception e) {
            Logger.logSevere(e.getMessage());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            FileChannel fileChannel = this.out;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException e) {
            Logger.logSevere(e);
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
        }
    }

    public void write(float[] fArr) {
        try {
            if (this.out != null) {
                short[] sArr = new short[fArr.length];
                for (int i = 0; i < fArr.length; i++) {
                    sArr[i] = (short) (fArr[i] * 32767.0f);
                }
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(fArr.length * 2);
                byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                byteBufferAllocate.asShortBuffer().put(sArr);
                this.out.write(byteBufferAllocate);
            }
        } catch (Exception e) {
            Logger.logSevere(e);
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
        }
    }

    public void write(Float[] fArr) {
        write(ScienceUtil.convertArray(fArr));
    }

    public void write(String str) {
        try {
            if (this.out != null) {
                this.out.write(ByteBuffer.wrap(str.getBytes()));
            }
        } catch (Exception e) {
            Logger.logSevere(e);
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
        }
    }

    public RawAudioWriter(Context context, String str) {
        this(context, str, false);
    }
}
