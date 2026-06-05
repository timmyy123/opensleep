package com.urbandroid.util.vorbis;

import com.urbandroid.sleep.mic.VosRecordingWriter;

/* JADX INFO: loaded from: classes5.dex */
public class VorbisFileOutputStream extends AudioOutputStream {
    private VorbisInfo info;
    private final int oggStreamIdx;

    static {
        System.loadLibrary(VosRecordingWriter.EXTENSION);
        System.loadLibrary("vorbis");
        System.loadLibrary("vorbis-stream");
    }

    public VorbisFileOutputStream(String str) {
        if (str != null) {
            this.oggStreamIdx = create(str, new VorbisInfo());
        } else {
            this.oggStreamIdx = -1;
        }
    }

    private native void closeStreamIdx(int i);

    private native int create(String str, VorbisInfo vorbisInfo);

    private native int writeStreamIdx(int i, short[] sArr, int i2, int i3);

    @Override // com.urbandroid.util.vorbis.AudioOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeStreamIdx(this.oggStreamIdx);
    }

    @Override // com.urbandroid.util.vorbis.AudioOutputStream
    public int getSampleRate() {
        return this.info.sampleRate;
    }

    @Override // com.urbandroid.util.vorbis.AudioOutputStream
    public int write(short[] sArr, int i, int i2) {
        return writeStreamIdx(this.oggStreamIdx, sArr, 0, i2);
    }

    public VorbisFileOutputStream(String str, VorbisInfo vorbisInfo) {
        this.info = vorbisInfo;
        this.oggStreamIdx = create(str, vorbisInfo);
    }
}
