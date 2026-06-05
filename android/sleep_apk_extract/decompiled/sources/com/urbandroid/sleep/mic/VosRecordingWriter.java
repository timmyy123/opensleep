package com.urbandroid.sleep.mic;

import com.facebook.internal.Utility;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.audio.AudioUtil;
import com.urbandroid.sleep.audio.persistent_recording.recording.Recording;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.vorbis.VorbisFileOutputStream;
import com.urbandroid.util.vorbis.VorbisInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes.dex */
public class VosRecordingWriter extends BaseRecordingWriter<VorbisFileOutputStream> implements IRecordingWriter {
    public static final String EXTENSION = "ogg";
    private final AtomicReference<Pair> pair;

    public class Pair {
        OutputStream destination;
        String vorbisFileName;

        public Pair(String str, OutputStream outputStream) {
            this.vorbisFileName = str;
            this.destination = outputStream;
        }
    }

    public VosRecordingWriter(AudioRecorderContext audioRecorderContext) {
        super(audioRecorderContext);
        this.pair = new AtomicReference<>(null);
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            }
            if (i == 0) {
                int i2 = inputStream.read();
                if (i2 < 0) {
                    return;
                } else {
                    outputStream.write(i2);
                }
            } else {
                outputStream.write(bArr, 0, i);
                outputStream.flush();
            }
        }
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public VorbisFileOutputStream createOutputStream(OutputStream outputStream, String str) {
        String str2 = SharedApplicationContext.getInstance().getContext().getCacheDir().getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
        this.pair.set(new Pair(str2, outputStream));
        return createOutputStream(str2);
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public String getExtension() {
        return EXTENSION;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onWritingStop() throws Throwable {
        FileInputStream fileInputStream;
        OutputStream outputStream;
        if (this.pair.get() == null) {
            return;
        }
        String str = this.pair.get().vorbisFileName;
        File file = new File(str);
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e) {
            e = e;
            fileInputStream = null;
            outputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            outputStream = null;
        }
        try {
            outputStream = this.pair.get().destination;
            try {
                try {
                    copyStream(fileInputStream, outputStream);
                    Logger.logDebug("Vorbis file " + str + " copied");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    Logger.logSevere("Fail to copy " + str, e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (fileInputStream != null) {
                    }
                    file.delete();
                    this.pair.set(null);
                }
            } catch (Throwable th2) {
                th = th2;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                file.delete();
                this.pair.set(null);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            if (outputStream != null) {
            }
            if (fileInputStream != null) {
            }
            file.delete();
            this.pair.set(null);
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused5) {
        }
        file.delete();
        this.pair.set(null);
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public void syncWriteToOutputStream(VorbisFileOutputStream vorbisFileOutputStream, Recording recording) throws IOException {
        if (vorbisFileOutputStream != null) {
            vorbisFileOutputStream.write(AudioUtil.toByte(recording.toArray()), 0, recording.size() * 2);
        }
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public void syncWriteToOutputStream(VorbisFileOutputStream vorbisFileOutputStream, AudioReadBuffer audioReadBuffer) {
        if (vorbisFileOutputStream != null) {
            vorbisFileOutputStream.write(audioReadBuffer.toShort(), 0, audioReadBuffer.length());
        }
    }

    @Override // com.urbandroid.sleep.mic.BaseRecordingWriter
    public VorbisFileOutputStream createOutputStream(String str) {
        VorbisInfo vorbisInfo = new VorbisInfo();
        vorbisInfo.sampleRate = this.sampleRate;
        vorbisInfo.channels = this.stereo ? 2 : 1;
        return new VorbisFileOutputStream(str, vorbisInfo);
    }
}
