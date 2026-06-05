package com.urbandroid.util.vorbis;

import com.urbandroid.sleep.mic.VosRecordingWriter;

/* JADX INFO: loaded from: classes5.dex */
public class VorbisFileInputStream extends AudioInputStream {
    private final VorbisInfo info;
    private final int oggStreamIdx;

    static {
        System.loadLibrary(VosRecordingWriter.EXTENSION);
        System.loadLibrary("vorbis");
        System.loadLibrary("vorbis-stream");
    }

    public VorbisFileInputStream(String str) {
        VorbisInfo vorbisInfo = new VorbisInfo();
        this.info = vorbisInfo;
        this.oggStreamIdx = create(str, vorbisInfo);
    }

    private native void closeStreamIdx(int i);

    private native int create(String str, VorbisInfo vorbisInfo);

    private native int readStreamIdx(int i, short[] sArr, int i2, int i3);

    private native long skipStreamIdx(int i, long j);

    @Override // com.urbandroid.util.vorbis.AudioInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeStreamIdx(this.oggStreamIdx);
    }

    public VorbisInfo getInfo() {
        return this.info;
    }

    @Override // com.urbandroid.util.vorbis.AudioInputStream
    public int read(short[] sArr, int i, int i2) {
        return readStreamIdx(this.oggStreamIdx, sArr, i, i2);
    }
}
