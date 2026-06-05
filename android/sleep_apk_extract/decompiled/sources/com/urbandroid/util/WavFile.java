package com.urbandroid.util;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class WavFile implements Closeable {
    private int blockAlign;
    private byte[] buffer = new byte[4096];
    private int bufferPointer;
    private int bytesPerSample;
    private int bytesRead;
    private File file;
    private double floatOffset;
    private double floatScale;
    private long frameCounter;
    private FileInputStream iStream;
    private IOState ioState;
    private int numChannels;
    private long numFrames;
    private FileOutputStream oStream;
    private long sampleRate;
    private int validBits;
    private boolean wordAlignAdjust;

    public enum IOState {
        READING,
        WRITING,
        CLOSED
    }

    public static class WavFileException extends RuntimeException {
        public /* synthetic */ WavFileException(String str, int i) {
            this(str);
        }

        private WavFileException(String str) {
            super(str);
        }
    }

    private WavFile() {
    }

    public static WavFile newWavFile(File file, int i, long j, int i2, long j2) throws IOException {
        WavFile wavFile = new WavFile();
        wavFile.file = file;
        wavFile.numChannels = i;
        wavFile.numFrames = j;
        wavFile.sampleRate = j2;
        int i3 = (i2 + 7) / 8;
        wavFile.bytesPerSample = i3;
        wavFile.blockAlign = i3 * i;
        wavFile.validBits = i2;
        int i4 = 0;
        if (i < 1 || i > 65535) {
            throw new WavFileException("Illegal number of channels, valid range 1 to 65536", i4);
        }
        if (j < 0) {
            throw new WavFileException("Number of frames must be positive", i4);
        }
        if (i2 < 2 || i2 > 65535) {
            throw new WavFileException("Illegal number of valid bits, valid range 2 to 65536", i4);
        }
        if (j2 < 0) {
            throw new WavFileException("MonoSample rate must be positive", i4);
        }
        wavFile.oStream = new FileOutputStream(file);
        long j3 = ((long) wavFile.blockAlign) * j;
        long j4 = 36 + j3;
        if (j3 % 2 == 1) {
            j4 = 37 + j3;
            wavFile.wordAlignAdjust = true;
        } else {
            wavFile.wordAlignAdjust = false;
        }
        putLE(1179011410L, wavFile.buffer, 0, 4);
        putLE(j4, wavFile.buffer, 4, 4);
        putLE(1163280727L, wavFile.buffer, 8, 4);
        wavFile.oStream.write(wavFile.buffer, 0, 12);
        long j5 = ((long) wavFile.blockAlign) * j2;
        putLE(544501094L, wavFile.buffer, 0, 4);
        putLE(16L, wavFile.buffer, 4, 4);
        putLE(1L, wavFile.buffer, 8, 2);
        putLE(i, wavFile.buffer, 10, 2);
        putLE(j2, wavFile.buffer, 12, 4);
        putLE(j5, wavFile.buffer, 16, 4);
        putLE(wavFile.blockAlign, wavFile.buffer, 20, 2);
        putLE(i2, wavFile.buffer, 22, 2);
        wavFile.oStream.write(wavFile.buffer, 0, 24);
        putLE(1635017060L, wavFile.buffer, 0, 4);
        putLE(j3, wavFile.buffer, 4, 4);
        wavFile.oStream.write(wavFile.buffer, 0, 8);
        if (wavFile.validBits > 8) {
            wavFile.floatOffset = 0.0d;
            wavFile.floatScale = 9223372036854775807 >> (64 - r0);
        } else {
            wavFile.floatOffset = 1.0d;
            wavFile.floatScale = ((double) ((1 << r0) - 1)) * 0.5d;
        }
        wavFile.bufferPointer = 0;
        wavFile.bytesRead = 0;
        wavFile.frameCounter = 0L;
        wavFile.ioState = IOState.WRITING;
        return wavFile;
    }

    private static void putLE(long j, byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i] = (byte) (255 & j);
            j >>= 8;
            i++;
        }
    }

    private void writeSample(long j) throws IOException {
        for (int i = 0; i < this.bytesPerSample; i++) {
            if (this.bufferPointer == 4096) {
                this.oStream.write(this.buffer, 0, 4096);
                this.bufferPointer = 0;
            }
            byte[] bArr = this.buffer;
            int i2 = this.bufferPointer;
            bArr[i2] = (byte) (255 & j);
            j >>= 8;
            this.bufferPointer = i2 + 1;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        FileInputStream fileInputStream = this.iStream;
        if (fileInputStream != null) {
            fileInputStream.close();
            this.iStream = null;
        }
        FileOutputStream fileOutputStream = this.oStream;
        if (fileOutputStream != null) {
            int i = this.bufferPointer;
            if (i > 0) {
                fileOutputStream.write(this.buffer, 0, i);
            }
            if (this.wordAlignAdjust) {
                this.oStream.write(0);
            }
            this.oStream.close();
            this.oStream = null;
        }
        this.ioState = IOState.CLOSED;
    }

    public int writeFrames(double[][] dArr, int i, int i2) throws IOException {
        if (this.ioState != IOState.WRITING) {
            OggIO$$ExternalSyntheticBUOutline0.m("Cannot write to WavFile instance");
            return 0;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.frameCounter == this.numFrames) {
                return i3;
            }
            for (int i4 = 0; i4 < this.numChannels; i4++) {
                writeSample((long) ((this.floatOffset + dArr[i4][i]) * this.floatScale));
            }
            i++;
            this.frameCounter++;
        }
        return i2;
    }

    public int writeFrames(double[][] dArr, int i) {
        return writeFrames(dArr, 0, i);
    }
}
