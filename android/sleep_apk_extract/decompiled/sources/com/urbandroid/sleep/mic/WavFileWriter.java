package com.urbandroid.sleep.mic;

import com.facebook.share.internal.ShareInternalUtility;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.util.ScienceUtil;
import com.urbandroid.util.WavFile;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/mic/WavFileWriter;", "", ShareInternalUtility.STAGING_PARAM, "", "sampleRate", "", "maxLengthSeconds", "", "<init>", "(Ljava/lang/String;JI)V", "wavFile", "Lcom/urbandroid/util/WavFile;", "write", "", "bytes", "", "close", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WavFileWriter {
    private WavFile wavFile;

    public WavFileWriter(String str, long j, int i) {
        str.getClass();
        try {
            this.wavFile = WavFile.newWavFile(new File(str), 1, j * ((long) i), 16, j);
        } catch (Exception e) {
            Logger.logSevere("WavFileWriter", e);
        }
    }

    public final synchronized void close() {
        WavFile wavFile = this.wavFile;
        if (wavFile != null) {
            if (wavFile != null) {
                try {
                    wavFile.close();
                } catch (Exception e) {
                    Logger.logSevere("WavFileWriter", e);
                }
            }
            this.wavFile = null;
        }
    }

    public final synchronized void write(byte[] bytes) {
        bytes.getClass();
        if (this.wavFile != null) {
            int length = bytes.length / 2;
            double[] dArrConvertArrayToDouble = ScienceUtil.convertArrayToDouble(new AudioReadBuffer(bytes, length, 0L).toFloat());
            dArrConvertArrayToDouble.getClass();
            double[][] dArr = {dArrConvertArrayToDouble};
            try {
                WavFile wavFile = this.wavFile;
                if (wavFile != null) {
                    wavFile.writeFrames(dArr, length);
                }
            } catch (Exception e) {
                Logger.logSevere("WavFileWriter", e);
            }
        }
    }
}
