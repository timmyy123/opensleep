package com.urbandroid.sleep.snoring.classifier.tfv4;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.record.Record;
import com.urbandroid.sleep.snoring.tensorflow.feature.MelSpectrumFeature;
import com.urbandroid.sleep.snoring.tensorflow.feature.WeirdRuntimeExceptionInAudio;
import com.urbandroid.sleep.snoring.tensorflow.model.ModelMetadata;
import com.urbandroid.sleep.snoring.tensorflow.model.TFLiteModel;
import com.urbandroid.sleep.snoring.tensorflow.model.Tensor2D;
import com.urbandroid.sleep.snoring.tensorflow.model.TensorShape;
import com.urbandroid.util.Experiments;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bj\u0002`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv4/TFLClassifier_10s_lmsd2_5cat;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "modelAsset", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", DeviceRequestsHelper.DEVICE_INFO_MODEL, "Lcom/urbandroid/sleep/snoring/tensorflow/model/TFLiteModel;", "logBuffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "lms", "Lcom/urbandroid/sleep/snoring/tensorflow/feature/MelSpectrumFeature;", "classify", "", "sample", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "doClassify", "close", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TFLClassifier_10s_lmsd2_5cat {
    private final Context context;
    private final MelSpectrumFeature lms;
    private final StringBuilder logBuffer;
    private final TFLiteModel model;
    private final String modelAsset;

    public TFLClassifier_10s_lmsd2_5cat(Context context, String str) {
        context.getClass();
        str.getClass();
        this.context = context;
        this.modelAsset = str;
        this.model = new TFLiteModel(context, new ModelMetadata(str, "", new TensorShape(1, 1024, 64, 1), "", 5));
        this.logBuffer = new StringBuilder();
        this.lms = new MelSpectrumFeature("LMS", 0.05f, 0.0096f, 64);
    }

    private final float[] doClassify(MonoSample sample) {
        Record record = new Record();
        record.set("SAMPLE", sample);
        try {
            Object obj = this.lms.apply(record).get("LMS");
            obj.getClass();
            float[] fArrProcess = this.model.process(new Tensor2D((float[][]) obj).normalize().rightPadX(1024).sliceX(0, 1024).flatten());
            if (Experiments.getInstance().isDetailedSoundRecognitionLoggingExperiment()) {
                if (this.logBuffer.length() > 0) {
                    this.logBuffer.append(";");
                }
                this.logBuffer.append("[" + ArraysKt___ArraysKt.joinToString$default(fArrProcess, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "]");
                if (this.logBuffer.length() > 2048) {
                    Logger.logDebug("TFL result: " + this.modelAsset + " " + ((Object) this.logBuffer));
                    StringsKt__StringBuilderJVMKt.clear(this.logBuffer);
                }
            }
            return fArrProcess;
        } catch (WeirdRuntimeExceptionInAudio e) {
            zza$$ExternalSyntheticOutline0.m(sample.size(), sample.getSampleRate(), "WeirdRuntimeExceptionInAudio TFLClassifier_3s_lmf_2L_025s.doClassify(): ", " ");
            throw e;
        }
    }

    public final float[] classify(MonoSample sample) {
        sample.getClass();
        if (sample.getSampleRate() != 24000) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(sample.getSampleRate(), "Illegal sample rate: "));
            return null;
        }
        if (sample.getDurationSeconds() >= 2.0d) {
            return doClassify(sample);
        }
        throw new IllegalArgumentException("Too short sample: " + sample.getDurationSeconds());
    }

    public final void close() {
        this.model.close();
    }
}
