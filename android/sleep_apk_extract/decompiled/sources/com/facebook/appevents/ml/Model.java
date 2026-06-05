package com.facebook.appevents.ml;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J+\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/ml/Model;", "", "weights", "", "", "Lcom/facebook/appevents/ml/MTensor;", "(Ljava/util/Map;)V", "convs0Bias", "convs0Weight", "convs1Bias", "convs1Weight", "convs2Bias", "convs2Weight", "embedding", "fc1Bias", "fc1Weight", "fc2Bias", "fc2Weight", "finalWeights", "", "predictOnMTML", "dense", "texts", "", "task", "(Lcom/facebook/appevents/ml/MTensor;[Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/appevents/ml/MTensor;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Model {
    private static final int SEQ_LEN = 128;
    private final MTensor convs0Bias;
    private final MTensor convs0Weight;
    private final MTensor convs1Bias;
    private final MTensor convs1Weight;
    private final MTensor convs2Bias;
    private final MTensor convs2Weight;
    private final MTensor embedding;
    private final MTensor fc1Bias;
    private final MTensor fc1Weight;
    private final MTensor fc2Bias;
    private final MTensor fc2Weight;
    private final Map<String, MTensor> finalWeights;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, String> mapping = MapsKt.hashMapOf(TuplesKt.to("embedding.weight", "embed.weight"), TuplesKt.to("dense1.weight", "fc1.weight"), TuplesKt.to("dense2.weight", "fc2.weight"), TuplesKt.to("dense3.weight", "fc3.weight"), TuplesKt.to("dense1.bias", "fc1.bias"), TuplesKt.to("dense2.bias", "fc2.bias"), TuplesKt.to("dense3.bias", "fc3.bias"));

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/ml/Model$Companion;", "", "()V", "SEQ_LEN", "", "mapping", "", "", InAppPurchaseConstants.METHOD_BUILD, "Lcom/facebook/appevents/ml/Model;", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "parse", "Lcom/facebook/appevents/ml/MTensor;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<String, MTensor> parse(File file) {
            Map<String, MTensor> modelWeights = Utils.parseModelWeights(file);
            if (modelWeights == null) {
                return null;
            }
            HashMap map = new HashMap();
            Map mapAccess$getMapping$cp = Model.access$getMapping$cp();
            for (Map.Entry<String, MTensor> entry : modelWeights.entrySet()) {
                String key = entry.getKey();
                if (mapAccess$getMapping$cp.containsKey(entry.getKey()) && (key = (String) mapAccess$getMapping$cp.get(entry.getKey())) == null) {
                    return null;
                }
                map.put(key, entry.getValue());
            }
            return map;
        }

        public final Model build(File file) {
            file.getClass();
            Map<String, MTensor> map = parse(file);
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (map == null) {
                return null;
            }
            try {
                return new Model(map, defaultConstructorMarker);
            } catch (Exception unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    private Model(Map<String, MTensor> map) {
        MTensor mTensor = map.get("embed.weight");
        if (mTensor == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.embedding = mTensor;
        MTensor mTensor2 = map.get("convs.0.weight");
        if (mTensor2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.convs0Weight = Operator.transpose3D(mTensor2);
        MTensor mTensor3 = map.get("convs.1.weight");
        if (mTensor3 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.convs1Weight = Operator.transpose3D(mTensor3);
        MTensor mTensor4 = map.get("convs.2.weight");
        if (mTensor4 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.convs2Weight = Operator.transpose3D(mTensor4);
        MTensor mTensor5 = map.get("convs.0.bias");
        if (mTensor5 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.convs0Bias = mTensor5;
        MTensor mTensor6 = map.get("convs.1.bias");
        if (mTensor6 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.convs1Bias = mTensor6;
        MTensor mTensor7 = map.get("convs.2.bias");
        if (mTensor7 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.convs2Bias = mTensor7;
        MTensor mTensor8 = map.get("fc1.weight");
        if (mTensor8 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.fc1Weight = Operator.transpose2D(mTensor8);
        MTensor mTensor9 = map.get("fc2.weight");
        if (mTensor9 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.fc2Weight = Operator.transpose2D(mTensor9);
        MTensor mTensor10 = map.get("fc1.bias");
        if (mTensor10 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.fc1Bias = mTensor10;
        MTensor mTensor11 = map.get("fc2.bias");
        if (mTensor11 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        this.fc2Bias = mTensor11;
        this.finalWeights = new HashMap();
        for (String str : SetsKt.setOf((Object[]) new String[]{ModelManager.Task.MTML_INTEGRITY_DETECT.toKey(), ModelManager.Task.MTML_APP_EVENT_PREDICTION.toKey()})) {
            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(str, ".weight");
            String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(str, ".bias");
            MTensor mTensor12 = map.get(strM$1);
            MTensor mTensor13 = map.get(strM$12);
            if (mTensor12 != null) {
                this.finalWeights.put(strM$1, Operator.transpose2D(mTensor12));
            }
            if (mTensor13 != null) {
                this.finalWeights.put(strM$12, mTensor13);
            }
        }
    }

    public static final /* synthetic */ Map access$getMapping$cp() {
        if (CrashShieldHandler.isObjectCrashing(Model.class)) {
            return null;
        }
        try {
            return mapping;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Model.class);
            return null;
        }
    }

    public final MTensor predictOnMTML(MTensor dense, String[] texts, String task) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            dense.getClass();
            texts.getClass();
            task.getClass();
            MTensor mTensorConv1D = Operator.conv1D(Operator.embedding(texts, SEQ_LEN, this.embedding), this.convs0Weight);
            Operator.addmv(mTensorConv1D, this.convs0Bias);
            Operator.relu(mTensorConv1D);
            MTensor mTensorConv1D2 = Operator.conv1D(mTensorConv1D, this.convs1Weight);
            Operator.addmv(mTensorConv1D2, this.convs1Bias);
            Operator.relu(mTensorConv1D2);
            MTensor mTensorMaxPool1D = Operator.maxPool1D(mTensorConv1D2, 2);
            MTensor mTensorConv1D3 = Operator.conv1D(mTensorMaxPool1D, this.convs2Weight);
            Operator.addmv(mTensorConv1D3, this.convs2Bias);
            Operator.relu(mTensorConv1D3);
            MTensor mTensorMaxPool1D2 = Operator.maxPool1D(mTensorConv1D, mTensorConv1D.getShape(1));
            MTensor mTensorMaxPool1D3 = Operator.maxPool1D(mTensorMaxPool1D, mTensorMaxPool1D.getShape(1));
            MTensor mTensorMaxPool1D4 = Operator.maxPool1D(mTensorConv1D3, mTensorConv1D3.getShape(1));
            Operator.flatten(mTensorMaxPool1D2, 1);
            Operator.flatten(mTensorMaxPool1D3, 1);
            Operator.flatten(mTensorMaxPool1D4, 1);
            MTensor mTensorDense = Operator.dense(Operator.concatenate(new MTensor[]{mTensorMaxPool1D2, mTensorMaxPool1D3, mTensorMaxPool1D4, dense}), this.fc1Weight, this.fc1Bias);
            Operator.relu(mTensorDense);
            MTensor mTensorDense2 = Operator.dense(mTensorDense, this.fc2Weight, this.fc2Bias);
            Operator.relu(mTensorDense2);
            MTensor mTensor = this.finalWeights.get(task + ".weight");
            MTensor mTensor2 = this.finalWeights.get(task + ".bias");
            if (mTensor != null && mTensor2 != null) {
                MTensor mTensorDense3 = Operator.dense(mTensorDense2, mTensor, mTensor2);
                Operator.softmax(mTensorDense3);
                return mTensorDense3;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public /* synthetic */ Model(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }
}
