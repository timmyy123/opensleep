package com.urbandroid.sleep.audio;

import android.content.Context;
import android.content.Intent;
import android.media.AudioRecord;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.sensor.sonar.SonarConfig;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecordBuilder;", "Lcom/urbandroid/common/FeatureLogger;", "audioFormat", "", "attempts", "channelConfig", "bufferSize", "sampleRates", "", "<init>", "(IIII[I)V", "tag", "", "getTag", "()Ljava/lang/String;", SDKConstants.PARAM_VALUE, "sampleRate", "getSampleRate", "()I", "", "isStereo", "()Z", InAppPurchaseConstants.METHOD_BUILD, "Landroid/media/AudioRecord;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioRecordBuilder implements FeatureLogger {
    private final int attempts;
    private final int audioFormat;
    private int bufferSize;
    private final int channelConfig;
    private boolean isStereo;
    private int sampleRate;
    private final int[] sampleRates;
    private final String tag;

    public /* synthetic */ AudioRecordBuilder(int i, int i2, int i3, int i4, int[] iArr, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 2 : i, (i5 & 2) != 0 ? 3 : i2, (i5 & 4) != 0 ? 16 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? new int[]{48000, 44100, 22050, 11025, 8000} : iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AudioRecord build() {
        int[] iArr;
        int i;
        int i2;
        AudioRecord audioRecord;
        AudioRecord audioRecord2;
        int i3;
        int i4 = SonarConfig.RECORDING_INPUT;
        int i5 = this.attempts;
        for (int i6 = 0; i6 < i5; i6++) {
            int[] iArr2 = this.sampleRates;
            int length = iArr2.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = length;
                int i9 = iArr2[i7];
                this.sampleRate = i9;
                int minBufferSize = AudioRecord.getMinBufferSize(i9, this.channelConfig, this.audioFormat);
                this.bufferSize = 131072;
                if (minBufferSize > 131072) {
                    String str = Logger.defaultTag;
                    StringBuilder sb = new StringBuilder();
                    iArr = iArr2;
                    sb.append(getTag());
                    sb.append(": ");
                    sb.append("Increasing buffer size from 131072 to " + minBufferSize + ".");
                    Logger.logInfo(str, sb.toString(), null);
                    this.bufferSize = minBufferSize;
                } else {
                    iArr = iArr2;
                }
                try {
                    i3 = i7;
                    try {
                        i2 = i8;
                    } catch (Exception e) {
                        e = e;
                        i2 = i8;
                    }
                } catch (Exception e2) {
                    e = e2;
                    i = i7;
                    i2 = i8;
                }
                try {
                    i = i3;
                } catch (Exception e3) {
                    e = e3;
                    i = i3;
                    audioRecord = null;
                    Context context = SharedApplicationContext.getInstance().getContext();
                    context.getClass();
                    ContextExtKt.sendExplicitBroadcast$default(context, new Intent("recording_initialization_failed"), null, 2, null);
                    int i10 = this.audioFormat;
                    String message = e.getMessage();
                    StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i9, i10, "AutoTracking Initialization of sample rate with: ", " audioFormat: ", " audio-source: ");
                    sbM.append(i4);
                    sbM.append(" failed with: ");
                    sbM.append(message);
                    String string = sbM.toString();
                    Logger.logInfo(Logger.defaultTag, getTag() + ": " + string, null);
                    audioRecord2 = audioRecord;
                    if (audioRecord2 != null) {
                    }
                    i7 = i + 1;
                    length = i2;
                    iArr2 = iArr;
                }
                try {
                    audioRecord2 = new AudioRecord(i4, i9, this.channelConfig, this.audioFormat, this.bufferSize);
                    try {
                    } catch (Exception e4) {
                        e = e4;
                    }
                } catch (Exception e5) {
                    e = e5;
                    audioRecord = null;
                }
                if (audioRecord2.getState() == 1) {
                    try {
                        this.isStereo = this.channelConfig == 12;
                        String str2 = "AutoTracking Starting recorder with sample rate: " + i9 + " Buffer size: " + this.bufferSize + " Stereo: false audioFormat: " + this.audioFormat + " audio-source: " + i4;
                        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
                        audioRecord2.startRecording();
                        SharedApplicationContext.getSettings().setFailedToInitRecording(false);
                        return audioRecord2;
                    } catch (Exception e6) {
                        e = e6;
                    }
                } else {
                    Context context2 = SharedApplicationContext.getInstance().getContext();
                    context2.getClass();
                    ContextExtKt.sendExplicitBroadcast$default(context2, new Intent("recording_initialization_failed"), null, 2, null);
                    String str3 = "AutoTracking Initialization with sample rate " + i9 + " audioFormat: " + this.audioFormat + " audio-source: " + i4 + " failed: " + audioRecord2.getState();
                    Logger.logDebug(Logger.defaultTag, getTag() + ": " + str3, null);
                    if (audioRecord2 != null) {
                        try {
                            audioRecord2.release();
                            Unit unit = Unit.INSTANCE;
                        } catch (Exception unused) {
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                    i7 = i + 1;
                    length = i2;
                    iArr2 = iArr;
                }
                audioRecord = audioRecord2;
                Context context3 = SharedApplicationContext.getInstance().getContext();
                context3.getClass();
                ContextExtKt.sendExplicitBroadcast$default(context3, new Intent("recording_initialization_failed"), null, 2, null);
                int i102 = this.audioFormat;
                String message2 = e.getMessage();
                StringBuilder sbM2 = Fragment$$ExternalSyntheticOutline1.m(i9, i102, "AutoTracking Initialization of sample rate with: ", " audioFormat: ", " audio-source: ");
                sbM2.append(i4);
                sbM2.append(" failed with: ");
                sbM2.append(message2);
                String string2 = sbM2.toString();
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + string2, null);
                audioRecord2 = audioRecord;
                if (audioRecord2 != null) {
                }
                i7 = i + 1;
                length = i2;
                iArr2 = iArr;
            }
        }
        SharedApplicationContext.getSettings().setFailedToInitRecording(true);
        return null;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: isStereo, reason: from getter */
    public final boolean getIsStereo() {
        return this.isStereo;
    }

    public AudioRecordBuilder(int i, int i2, int i3, int i4, int[] iArr) {
        iArr.getClass();
        this.audioFormat = i;
        this.attempts = i2;
        this.channelConfig = i3;
        this.bufferSize = i4;
        this.sampleRates = iArr;
        this.tag = "AudioRecorder:Initialization";
    }
}
