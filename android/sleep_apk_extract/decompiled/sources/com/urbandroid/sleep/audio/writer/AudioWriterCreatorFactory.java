package com.urbandroid.sleep.audio.writer;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.mic.IRecordingWriter;
import com.urbandroid.sleep.mic.MediaCodecWriter;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.Experiments;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AudioWriterCreatorFactory {

    public static class MediaCodecAudioWriterCreator implements AudioWriterCreator {
        public /* synthetic */ MediaCodecAudioWriterCreator(int i) {
            this();
        }

        @Override // com.urbandroid.sleep.audio.writer.AudioWriterCreator
        public IRecordingWriter createWriter(AudioRecorderContext audioRecorderContext) {
            Logger.logInfo("SleepService: MediaCodecWriter " + audioRecorderContext.getSampleRate());
            return new MediaCodecWriter(audioRecorderContext);
        }

        private MediaCodecAudioWriterCreator() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006a A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:16:0x003d, B:24:0x0057, B:22:0x004d, B:26:0x0062, B:28:0x006a, B:29:0x0099), top: B:37:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AudioWriterCreator detect() {
        ClassLoader classLoader = AudioWriterCreatorFactory.class.getClassLoader();
        boolean zIsRecordingMasterSwitchEnabled = SharedApplicationContext.getSettings().isRecordingMasterSwitchEnabled();
        int i = 0;
        boolean z = zIsRecordingMasterSwitchEnabled && (SharedApplicationContext.getSettings().isRecordingEnabled() || (zIsRecordingMasterSwitchEnabled && SharedApplicationContext.getSettings().isExperimentalNoiseRecoringEnabled()));
        boolean zIsBrokenMediaCodecDevice = Experiments.getInstance().isBrokenMediaCodecDevice();
        if (zIsBrokenMediaCodecDevice) {
            if (zIsBrokenMediaCodecDevice) {
            }
            final Class<?> clsLoadClass = classLoader.loadClass("com.urbandroid.sleep.mic.VosRecordingWriter");
            if (z) {
            }
            return new AudioWriterCreator() { // from class: com.urbandroid.sleep.audio.writer.AudioWriterCreatorFactory.1
                @Override // com.urbandroid.sleep.audio.writer.AudioWriterCreator
                public IRecordingWriter createWriter(AudioRecorderContext audioRecorderContext) {
                    Logger.logInfo("SleepService: Vorbis " + audioRecorderContext.getSampleRate());
                    try {
                        return (IRecordingWriter) clsLoadClass.getConstructor(AudioRecorderContext.class).newInstance(audioRecorderContext);
                    } catch (Throwable th) {
                        Utf8$$ExternalSyntheticBUOutline0.m(th);
                        return null;
                    }
                }
            };
        }
        try {
            if (SharedApplicationContext.getSettings().getNoiseOutput() == 2) {
                if (zIsBrokenMediaCodecDevice || SharedApplicationContext.getSettings().getNoiseOutput() != 1) {
                    final Class clsLoadClass2 = classLoader.loadClass("com.urbandroid.sleep.mic.VosRecordingWriter");
                    if (z) {
                        Class<?> clsLoadClass3 = classLoader.loadClass("com.urbandroid.util.vorbis.VorbisFileOutputStream");
                        Logger.logInfo("SleepService:Recording Using Vorbis, binary is supported: " + clsLoadClass3 + " .. " + clsLoadClass3.getConstructor(String.class).newInstance(null));
                    }
                    return new AudioWriterCreator() { // from class: com.urbandroid.sleep.audio.writer.AudioWriterCreatorFactory.1
                        @Override // com.urbandroid.sleep.audio.writer.AudioWriterCreator
                        public IRecordingWriter createWriter(AudioRecorderContext audioRecorderContext) {
                            Logger.logInfo("SleepService: Vorbis " + audioRecorderContext.getSampleRate());
                            try {
                                return (IRecordingWriter) clsLoadClass2.getConstructor(AudioRecorderContext.class).newInstance(audioRecorderContext);
                            } catch (Throwable th) {
                                Utf8$$ExternalSyntheticBUOutline0.m(th);
                                return null;
                            }
                        }
                    };
                }
            }
        } catch (Throwable th) {
            Logger.logSevere("SleepService:Failed to instantiate audio writer creator ", th);
            if (Environment.isNewJellyBeanOrGreater()) {
                Logger.logInfo("SleepService:Recording Using MediaCodes Fallback");
                return new MediaCodecAudioWriterCreator(i);
            }
            Logger.logWarning("SleepService:No Audio writer found", th);
            return null;
        }
        Logger.logInfo("SleepService:Recording Using MediaCodes");
        return new MediaCodecAudioWriterCreator(i);
    }
}
