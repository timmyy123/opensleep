package com.urbandroid.sleep.mic;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.audio.AudioUtil;
import com.urbandroid.sleep.audio.persistent_recording.recording.Recording;
import com.urbandroid.sleep.audio.transform.AudioTransformer;
import com.urbandroid.util.Experiments;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class MediaCodecWriter extends BaseRecordingWriter<OutputStream> implements IRecordingWriter {
    public static final String EXTENSION = "m4a";
    private AudioTransformer audioTransformer;
    private MediaCodec codec;
    private WavFileWriter wavFile;

    public MediaCodecWriter(AudioRecorderContext audioRecorderContext) {
        super(audioRecorderContext);
        StringBuilder sb = new StringBuilder("MediaCodec: Created media codec writer. Sample rate: ");
        sb.append(this.sampleRate);
        sb.append(" Stereo: ");
        zza$$ExternalSyntheticOutline0.m(sb, this.stereo);
    }

    private int getFrequencyIndex(int i) {
        if (i == 8000) {
            return 11;
        }
        if (i == 11025) {
            return 10;
        }
        if (i == 22050) {
            return 7;
        }
        if (i == 44100) {
            return 4;
        }
        if (i == 48000) {
            return 3;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Unsupported sample rate: "));
        return 0;
    }

    private byte[] toAdtsFrame(ByteBuffer byteBuffer, int i) {
        int i2 = i + 7;
        int frequencyIndex = getFrequencyIndex(this.sampleRate);
        byte[] bArr = new byte[i2];
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) ((frequencyIndex << 2) + 64);
        bArr[3] = (byte) (64 + (i2 >> 11));
        bArr[4] = (byte) ((i2 & 2047) >> 3);
        bArr[5] = (byte) (((i2 & 7) << 5) + 31);
        bArr[6] = -4;
        byteBuffer.position(0);
        byteBuffer.get(bArr, 7, i);
        return bArr;
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public OutputStream createOutputStream(String str) {
        return new FileOutputStream(str);
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public String getExtension() {
        return EXTENSION;
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public void onStop() {
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.codec.release();
            } catch (Exception e) {
                Logger.logWarning("Failed to close MediaCodec properly", e);
            }
            this.codec = null;
        }
        WavFileWriter wavFileWriter = this.wavFile;
        if (wavFileWriter != null) {
            wavFileWriter.close();
            this.wavFile = null;
        }
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public void onWritingStart() {
        try {
            this.codec = MediaCodec.createEncoderByType("audio/mp4a-latm");
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", "audio/mp4a-latm");
            mediaFormat.setInteger("bitrate", (Experiments.getInstance().is128BitRateExperiment() ? 128 : 64) * 1024);
            mediaFormat.setInteger("channel-count", 1);
            mediaFormat.setInteger("sample-rate", this.sampleRate);
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("max-input-size", this.sampleRate * 2);
            this.codec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            this.codec.start();
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public void onWritingStop() {
        if (this.codec != null) {
            Logger.logInfo("Stopping codec.");
            try {
                this.codec.stop();
                this.codec.release();
            } catch (Exception e) {
                Logger.logWarning("Failed to close MediaCodec properly", e);
            }
            this.codec = null;
        }
        WavFileWriter wavFileWriter = this.wavFile;
        if (wavFileWriter != null) {
            wavFileWriter.close();
            this.wavFile = null;
        }
    }

    public void syncWriteToOutputStream(OutputStream outputStream, byte[] bArr) {
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null) {
            return;
        }
        try {
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = this.codec.getOutputBuffers();
            int length = bArr.length;
            int i = 0;
            while (true) {
                int i2 = length - i;
                if (i2 <= 0) {
                    break;
                }
                int iDequeueInputBuffer = this.codec.dequeueInputBuffer(100000L);
                if (iDequeueInputBuffer >= 0) {
                    int iMin = Math.min(inputBuffers[iDequeueInputBuffer].capacity(), i2);
                    inputBuffers[iDequeueInputBuffer].clear();
                    inputBuffers[iDequeueInputBuffer].position(0);
                    inputBuffers[iDequeueInputBuffer].put(bArr, i, iMin);
                    this.codec.queueInputBuffer(iDequeueInputBuffer, 0, iMin, 100000L, 0);
                    i2 = iMin;
                }
                i += i2;
                while (true) {
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    int iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, 100000L);
                    if (iDequeueOutputBuffer >= 0) {
                        if ((bufferInfo.flags & 2) == 0) {
                            outputStream.write(toAdtsFrame(outputBuffers[iDequeueOutputBuffer], bufferInfo.size));
                        }
                        this.codec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    } else if (iDequeueOutputBuffer == -3) {
                        outputBuffers = this.codec.getOutputBuffers();
                    } else if (iDequeueOutputBuffer == -2) {
                        Logger.logDebug("Format changed.");
                    }
                }
            }
            WavFileWriter wavFileWriter = this.wavFile;
            if (wavFileWriter != null) {
                wavFileWriter.write(bArr);
            }
        } catch (Exception e) {
            Logger.logSevere("MediaCodecWriter failure", e);
        }
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public OutputStream createOutputStream(OutputStream outputStream, String str) {
        return outputStream;
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    @Deprecated
    public void syncWriteToOutputStream(OutputStream outputStream, AudioReadBuffer audioReadBuffer) {
        syncWriteToOutputStream(outputStream, audioReadBuffer.getRawData());
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public void syncWriteToOutputStream(OutputStream outputStream, Recording recording) {
        syncWriteToOutputStream(outputStream, AudioUtil.toByte(recording.toArray()));
    }
}
