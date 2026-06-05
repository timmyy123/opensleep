package com.urbandroid.sleep.snoring.classifier.tfv3;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.record.Record;
import com.urbandroid.sleep.snoring.tensorflow.feature.MelSpectrumFeature;
import com.urbandroid.sleep.snoring.tensorflow.feature.RelativeAmplitudeFeature;
import com.urbandroid.sleep.snoring.tensorflow.feature.WeirdRuntimeExceptionInAudio;
import com.urbandroid.sleep.snoring.tensorflow.model.ModelMetadata;
import com.urbandroid.sleep.snoring.tensorflow.model.TFLiteModel;
import com.urbandroid.sleep.snoring.tensorflow.model.Tensor2D;
import com.urbandroid.sleep.snoring.tensorflow.model.TensorShape;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.ScienceUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv3/TFLClassifier_3s_lmf_2L_025s;", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "modelAsset", "", "inputNodeName", "outputNodeName", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", DeviceRequestsHelper.DEVICE_INFO_MODEL, "Lcom/urbandroid/sleep/snoring/tensorflow/model/TFLiteModel;", "lms", "Lcom/urbandroid/sleep/snoring/tensorflow/feature/MelSpectrumFeature;", "ampl", "Lcom/urbandroid/sleep/snoring/tensorflow/feature/RelativeAmplitudeFeature;", "classify", "sample", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)Ljava/lang/Double;", "doClassify", "getInputSampleRate", "", "getInputLengthSeconds", "close", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TFLClassifier_3s_lmf_2L_025s implements AudioClassifier<Double> {
    private final RelativeAmplitudeFeature ampl;
    private final Context context;
    private final String inputNodeName;
    private final MelSpectrumFeature lms;
    private final TFLiteModel model;
    private final String modelAsset;
    private final String outputNodeName;

    public TFLClassifier_3s_lmf_2L_025s(Context context, String str, String str2, String str3) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.context = context;
        this.modelAsset = str;
        this.inputNodeName = str2;
        this.outputNodeName = str3;
        this.model = new TFLiteModel(context, new ModelMetadata(str, str2, new TensorShape(1, 239, 42, 2), str3, 2));
        this.lms = new MelSpectrumFeature("LMS", 0.025f, 0.0125f, 42);
        this.ampl = new RelativeAmplitudeFeature("AMPL", 0.025f, 0.0125f);
    }

    private final double doClassify(MonoSample sample) {
        Record record = new Record();
        record.set("SAMPLE", sample);
        try {
            Record recordApply = this.ampl.apply(this.lms.apply(record));
            Object obj = recordApply.get("LMS");
            obj.getClass();
            Tensor2D tensor2D = new Tensor2D((float[][]) obj);
            Tensor2D.Companion companion = Tensor2D.INSTANCE;
            Object obj2 = recordApply.get("AMPL");
            obj2.getClass();
            float[] fArrProcess = this.model.process(tensor2D.concatenateZAndFlatten(companion.tileY((float[]) obj2, 42)));
            int iArgmax = ScienceUtil.argmax(fArrProcess);
            if (Experiments.getInstance().isDetailedSoundRecognitionLoggingExperiment()) {
                String str = this.modelAsset;
                String strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(fArrProcess, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(iArgmax, "TFL result: ", str, " ", " [");
                sbM.append(strJoinToString$default);
                sbM.append("]");
                Logger.logDebug(sbM.toString());
            }
            if (iArgmax >= 0 && iArgmax != 0) {
                return fArrProcess[iArgmax];
            }
            return 0.0d;
        } catch (WeirdRuntimeExceptionInAudio e) {
            zza$$ExternalSyntheticOutline0.m(sample.size(), sample.getSampleRate(), "WeirdRuntimeExceptionInAudio TFLClassifier_3s_lmf_2L_025s.doClassify(): ", " ");
            throw e;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public Double classify(MonoSample sample) {
        sample.getClass();
        if (sample.getSampleRate() != getSampleRate()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(sample.getSampleRate(), "Illegal sample rate: "));
            return null;
        }
        if (sample.getDurationSeconds() == getHistorySize()) {
            return Double.valueOf(doClassify(sample));
        }
        throw new IllegalArgumentException("Illegal sample length: " + sample.getDurationSeconds());
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public void close() {
        this.model.close();
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    /* JADX INFO: renamed from: getInputLengthSeconds */
    public double getHistorySize() {
        return 3.0d;
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    /* JADX INFO: renamed from: getInputSampleRate */
    public int getSampleRate() {
        return 12000;
    }

    public /* synthetic */ TFLClassifier_3s_lmf_2L_025s(Context context, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? "conv2d_1_input" : str2, (i & 8) != 0 ? "dense_3/Softmax" : str3);
    }
}
