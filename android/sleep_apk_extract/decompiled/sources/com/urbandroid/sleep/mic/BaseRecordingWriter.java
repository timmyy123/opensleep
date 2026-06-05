package com.urbandroid.sleep.mic;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.audio.persistent_recording.recording.Recording;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.media.NoiseDirectoryException;
import com.urbandroid.sleep.mic.IRecordingWriter;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRecordingWriter<T extends OutputStream> implements IRecordingWriter {
    public static final String FILE_NAME_PREFIX = "rec.";
    public static final String RECORD_PATH = "/sleep-data/rec/";
    private static File directory;
    private IRecordingWriter.Listener listener;
    protected AudioRecorderContext recorderContext;
    protected final int sampleRate;
    protected final boolean stereo;
    private T os = null;
    private final int MAX_UNDER_THRESHOLD_SAVE = 4;
    private boolean isRecording = false;
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 5, TimeUnit.MINUTES, new ArrayBlockingQueue(50), new ThreadPoolExecutor.DiscardPolicy());

    public class SafStartWritingCommand implements Callable<DocumentFile> {
        private final Context context;
        private final IRecordingWriter.FailureListener failureListener;
        private final String fileName;

        public SafStartWritingCommand(Context context, String str, IRecordingWriter.FailureListener failureListener) {
            this.fileName = str;
            this.context = context;
            this.failureListener = failureListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public DocumentFile call() {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                NoiseDirectory noiseDirectory = new NoiseDirectory(this.context);
                DocumentFile documentFilePrepareNoiseDir = noiseDirectory.prepareNoiseDir();
                BaseRecordingWriter.this.onWritingStart();
                DocumentFile documentFileCreateFile = documentFilePrepareNoiseDir.createFile("audio/" + BaseRecordingWriter.this.getExtension(), this.fileName);
                if (documentFileCreateFile == null) {
                    throw new IOException("Unable to create audio file:" + documentFilePrepareNoiseDir.getUri() + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.fileName);
                }
                Logger.logInfo("AudioFile created: " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms " + documentFileCreateFile.getUri());
                BaseRecordingWriter baseRecordingWriter = BaseRecordingWriter.this;
                baseRecordingWriter.os = baseRecordingWriter.createOutputStream(noiseDirectory.getOutputStream(documentFileCreateFile), documentFileCreateFile.getName());
                return documentFileCreateFile;
            } catch (NoiseDirectoryException e) {
                BaseRecordingWriter.this.isRecording = false;
                Logger.logWarning(this.fileName + ": NoiseDirectoryException in noise writing.", e);
                IRecordingWriter.FailureListener failureListener = this.failureListener;
                if (failureListener == null) {
                    return null;
                }
                failureListener.fail(e.toString());
                return null;
            } catch (IOException e2) {
                BaseRecordingWriter.this.isRecording = false;
                Logger.logWarning("Exception in noise writing.", e2);
                return null;
            }
        }
    }

    public class StartWritingCommand implements Runnable {
        private final String fileName;

        public StartWritingCommand(String str) {
            this.fileName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (BaseRecordingWriter.directory == null) {
                    BaseRecordingWriter.directory = new File(this.fileName).getParentFile();
                    if (!BaseRecordingWriter.directory.exists() && !BaseRecordingWriter.directory.mkdirs()) {
                        Logger.logSevere("Path to file could not be created.");
                        return;
                    }
                    File file = new File(BaseRecordingWriter.getRecordFolder() + ".nomedia");
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException unused) {
                        }
                    }
                }
                BaseRecordingWriter.this.onWritingStart();
                BaseRecordingWriter baseRecordingWriter = BaseRecordingWriter.this;
                baseRecordingWriter.os = baseRecordingWriter.createOutputStream(this.fileName);
            } catch (IOException e) {
                BaseRecordingWriter.this.isRecording = false;
                Logger.logWarning("Exception in noise writing.", e);
            }
        }
    }

    public BaseRecordingWriter(AudioRecorderContext audioRecorderContext) {
        this.sampleRate = audioRecorderContext.getSampleRate();
        this.stereo = audioRecorderContext.hasFeature(AudioRecorderContext.Feature.STEREO);
        this.recorderContext = audioRecorderContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getRecordFolder() {
        return SharedApplicationContext.getSettings().getNoiseWritableStoragePath() + RECORD_PATH;
    }

    public abstract T createOutputStream(OutputStream outputStream, String str);

    public abstract T createOutputStream(String str);

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    @Deprecated
    public long flushPendingBuffers(LinkedList<AudioReadBuffer> linkedList, boolean z, List<Float> list) {
        long j = 0;
        if (linkedList.size() == 0) {
            return 0L;
        }
        Iterator<AudioReadBuffer> it = linkedList.iterator();
        int i = 0;
        while (it.hasNext() && (z || i <= 4)) {
            AudioReadBuffer next = it.next();
            long readTimestamp = next.getReadTimestamp();
            writeBuffer(next, list);
            i++;
            j = readTimestamp;
        }
        linkedList.clear();
        return j;
    }

    public abstract String getExtension();

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    public String getNewRecordingFileName(long j) {
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(FILE_NAME_PREFIX, ".", j);
        sbM.append(getExtension());
        String string = sbM.toString();
        return SharedApplicationContext.getSettings().hasNoiseDirUri() ? string : FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), getRecordFolder(), string);
    }

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    public void interrupt() {
        this.threadPool.shutdown();
    }

    @Override // com.urbandroid.sleep.mic.IRecordingStateObserver
    public boolean isRecording() {
        return this.isRecording;
    }

    public void onStop() {
    }

    public void onWritingStart() {
    }

    public abstract void onWritingStop();

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    public Future<DocumentFile> safStartWritingToFile(String str, IRecordingWriter.FailureListener failureListener) {
        this.isRecording = true;
        return this.threadPool.submit(new SafStartWritingCommand(SharedApplicationContext.getInstance().getContext(), str, failureListener));
    }

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    public void setListener(IRecordingWriter.Listener listener) {
        this.listener = listener;
    }

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    public void startWritingToFile(String str) {
        this.isRecording = true;
        this.threadPool.execute(new StartWritingCommand(str));
    }

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    public void stopWritingToFile(final Runnable runnable) {
        this.isRecording = false;
        this.threadPool.execute(new Runnable() { // from class: com.urbandroid.sleep.mic.BaseRecordingWriter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BaseRecordingWriter.this.os != null) {
                        BaseRecordingWriter.this.os.flush();
                        BaseRecordingWriter.this.os.close();
                        Runnable runnable2 = runnable;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                        BaseRecordingWriter.this.os = null;
                    }
                    BaseRecordingWriter.this.onWritingStop();
                } catch (IOException e) {
                    Logger.logWarning("Exception in noise writing.", e);
                }
            }
        });
    }

    @Deprecated
    public abstract void syncWriteToOutputStream(T t, AudioReadBuffer audioReadBuffer);

    public abstract void syncWriteToOutputStream(T t, Recording recording);

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    @Deprecated
    public void writeBuffer(final AudioReadBuffer audioReadBuffer, List<Float> list) {
        list.addAll(audioReadBuffer.getMaxAmplitudes());
        this.threadPool.execute(new Runnable() { // from class: com.urbandroid.sleep.mic.BaseRecordingWriter.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BaseRecordingWriter.this.os != null) {
                        BaseRecordingWriter baseRecordingWriter = BaseRecordingWriter.this;
                        baseRecordingWriter.syncWriteToOutputStream(baseRecordingWriter.os, audioReadBuffer);
                    }
                } catch (IOException e) {
                    Logger.logWarning("Exception in noise writing.", e);
                }
            }
        });
    }

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    public void writeBuffer(final Recording recording) {
        this.threadPool.execute(new Runnable() { // from class: com.urbandroid.sleep.mic.BaseRecordingWriter.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BaseRecordingWriter.this.os != null) {
                        BaseRecordingWriter baseRecordingWriter = BaseRecordingWriter.this;
                        baseRecordingWriter.syncWriteToOutputStream(baseRecordingWriter.os, recording);
                    }
                } catch (IOException e) {
                    Logger.logWarning("Exception in noise writing.", e);
                }
            }
        });
        IRecordingWriter.Listener listener = this.listener;
        if (listener != null) {
            listener.recordingStored(recording);
        }
    }

    @Override // com.urbandroid.sleep.mic.IRecordingWriter
    public long flushPendingBuffers(LinkedList<Recording> linkedList, boolean z) {
        Iterator<Recording> it = linkedList.iterator();
        long j = 0;
        int i = 0;
        while (it.hasNext() && (z || i <= 4)) {
            Recording next = it.next();
            long startTime = next.getStartTime();
            writeBuffer(next);
            i++;
            j = startTime;
        }
        linkedList.clear();
        return j;
    }
}
